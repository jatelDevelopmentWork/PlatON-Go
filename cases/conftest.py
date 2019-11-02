import pytest
import socket
import allure
import os
from common import download
from environment.env import create_env
from common.log import log


def set_report_env(allure_dir, env):
    node = env.get_rand_node()
    version_info_list = node.run_ssh("{} version".format(node.remote_bin_file))
    version_info = "".join(version_info_list).replace(" ", "").replace("Platon\n", "")
    allure_dir_env = os.path.join(allure_dir, "environment.properties")
    consensus_node = "ConsensusNodes:{}\n".format("|".join([node.node_mark for node in env.consensus_node_list]))
    normal_node = "NormalNodes:{}\n".format("|".join([node.node_mark for node in env.normal_node_list]))
    env_id = "TestEnvironmentID:{}\n".format(env.cfg.env_id)
    with open(allure_dir_env, "w", encoding="UTF-8")as f:
        f.write(version_info)
        f.write(consensus_node)
        f.write(normal_node)
        f.write(env_id)


@pytest.fixture(scope="module")
def consensus_test_env(global_test_env):
    with open("/etc/passwd") as f:
        yield f.readlines()


def pytest_addoption(parser):
    parser.addoption("--job", action="store", help="job: ci run job id")
    parser.addoption("--tmpDir", action="store", help="tmpDir: tmp dir, default in deploy/tmp/global")
    parser.addoption("--platonUrl", action="store", help="platonUrl: url to download platon bin")
    parser.addoption("--nodeFile", action="store", help="nodeFile: the node config file")
    parser.addoption("--accountFile", action="store", help="accountFile: the accounts file")
    parser.addoption("--initChain", action="store_true", default=True, dest="initChain", help="nodeConfig: default to init chain data")
    parser.addoption("--installDependency", action="store_true", default=False, dest="installDependency", help="installDependency: default do not install dependencies")
    parser.addoption("--installSupervisor", action="store_true", default=False, dest="installSuperVisor", help="installSupervisor: default do not install supervisor service")

# py.test test_start.py -s --concmode=asyncnet --nodeFile "deploy/4_node.yml" --accountFile "deploy/accounts.yml" --initChain
# py.test 'tests/chain/test_chain_deploy.py' --nodeFile "deploy/node/test_chaininfo.yml" --accountFile "deploy/accounts.yml" --alluredir="report/allure" -s -v
@pytest.fixture(scope="session", autouse=False)
def global_test_env(request):
    log.info("global_test_env>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    tmp_dir = request.config.getoption("--tmpDir")
    node_file = request.config.getoption("--nodeFile")
    account_file = request.config.getoption("--accountFile")
    init_chain = request.config.getoption("--initChain")
    install_dependency = request.config.getoption("--installDependency")
    install_supervisor = request.config.getoption("--installSupervisor")
    plant_url = request.config.getoption("--platonUrl")
    allure_dir = request.config.getoption("--alluredir")
    if plant_url:
        download.download_platon(plant_url)
    env = create_env(tmp_dir, node_file, account_file, init_chain, install_dependency, install_supervisor)
    # env.deploy_all()
    # env.prepare_all()
    yield env

    if allure_dir:
        set_report_env(allure_dir, env)

    # delete env and close env
    # env.shutdown()


@pytest.hookimpl(tryfirst=True, hookwrapper=True)
def pytest_runtest_makereport(item, call):
    # execute all other hooks to obtain the report object
    outcome = yield
    rep = outcome.get_result()
    # we only look at actual failing test calls, not setup/teardown
    if rep.when == "call" and not rep.passed:
        # download log in here
        try:
            if 'global_test_env' in item.fixturenames:
                log_name = item.funcargs["global_test_env"].backup_all_logs(item.name)
                job = item.funcargs["request"].config.getoption("--job")
                if job is None:
                    log_url = os.path.join(item.funcargs["global_test_env"].cfg.bug_log, log_name)
                else:
                    log_url = "http://{}:8080/job/PlatON/job/run/{}/artifact/logs/{}".format(socket.gethostbyname(socket.gethostname()), job, log_name)
                allure.attach('{}'.format(log_url), 'Node log', allure.attachment_type.URI_LIST)
                log.error("node blocks:{}".format(item.funcargs["global_test_env"].block_numbers()))
        except Exception as e:
            log.info("exception:{}".format(e))
        # todo
        # allure.attach('http://www.implement.me.com', 'Node log', allure.attachment_type.URI_LIST)
