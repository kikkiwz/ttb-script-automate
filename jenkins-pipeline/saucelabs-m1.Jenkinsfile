import java.time.*
import java.time.format.DateTimeFormatter

def getBitbucketConf() {

    def domain = "bitbucket.tmbbank.local"
    def port = "7990"
    def bitbucket = [
        'branch' : 'develop',
        'url': "https://${domain}:${port}",
        'domain': domain,
        'port': port,
        'jenkinsCredentialsId' : 'jenkins_autoForBitbucket'
    ]

    return bitbucket
}

def getNexusConf(){
    return [
        'url' : 'nexus.tmbbank.local:8081',
        'dockerUrl' : 'nexus.tmbbank.local:60031',
        'username' : 'oneapp',
        'password' : 'ad123Tmb*',
        'jenkinsCredentialsId' : '5880caf8-5fe8-4567-a99f-227560f75fc2'
    ]
}
def getSaucelabsUIParameters () {
    def parameters = []
    parameters = [
        [
            $class: 'ChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            name: 'Squad',
            description: 'Select the squad',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["Please select squad"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["SmokeSuite", "Autoloan", "Customer-Service", "Investment", "IT4IT", "Lending", "PB1", "PB2", "Platform 1", "Platform 2", "Protection"]'
                ]
            ]
        ],
        [
            $class: 'ChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            name: 'TestEnv',
            description: 'Select the environment',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["Please select the testing environment"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["-- Select --", "Dev", "VIT", "UAT2"]'
                ]
            ]
        ],
        [
            $class: 'CascadeChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            name: 'Platform',
            description: 'Select the platform',
            referencedParameters: 'TestingType',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["Please select the platform"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: '''
                        return["-- Select --", "Android", "iOS"]
                    '''
                ]
            ]
        ],
        [
            $class: 'CascadeChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            name: 'XmlFiles',
            description: 'Selected the test suite file',
            referencedParameters: 'Squad,Platform',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["Please select the test suite"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: '''
                        if (Squad.equals("-- Select --") || Platform.equals("-- Select --")) { return["Default"] }
                        else if (Squad.equals("Autoloan") && Platform.equals("Android")) { return["AutoLoan_Android"] }
                        else if (Squad.equals("Autoloan") && Platform.equals("iOS")) { return["AutoLoaniOS"] }
                        else if (Squad.equals("Investment") && Platform.equals("Android")) { return["Investment_Android"] }
                        else if (Squad.equals("Investment") && Platform.equals("iOS")) { return["Investment_iOS"] }
                        else if (Squad.equals("Lending") && Platform.equals("Android")) { return["Lending_Android"] }
                        else if (Squad.equals("Lending") && Platform.equals("iOS")) { return["Lending_iOS"] }
                        else if (Squad.equals("Customer-Service") && Platform.equals("Android")) { return["CustomerService_Android"] }
                        else if (Squad.equals("Customer-Service") && Platform.equals("iOS")) { return["CustomerService_iOS"] }
                        else if (Squad.equals("PB1") && Platform.equals("Android")) { return["PrimaryBanking_1_Android"] }
                        else if (Squad.equals("PB1") && Platform.equals("iOS")) { return["PrimaryBanking_1_iOS"] }
                        else if (Squad.equals("PB2") && Platform.equals("Android")) { return["PrimaryBanking_2_Android"] }
                        else if (Squad.equals("PB2") && Platform.equals("iOS")) { return["PrimaryBanking_2_iOS"] }
                        else if (Squad.equals("Platform 1") && Platform.equals("Android")) { return["Platform1_Android"] }
                        else if (Squad.equals("Platform 1") && Platform.equals("iOS")) { return["Platform1_iOS"] }
                        else if (Squad.equals("Platform 2") && Platform.equals("Android")) { return["Platform2_Android"] }
                        else if (Squad.equals("Platform 2") && Platform.equals("iOS")) { return["Platform2_iOS"] }
                        else if (Squad.equals("Protection") && Platform.equals("Android")) { return["Protection_Android"] }
                        else if (Squad.equals("Protection") && Platform.equals("iOS")) { return["Protection_iOS"] }
                        else if (Squad.equals("SmokeSuite") && Platform.equals("Android")) { return["SmokeSuite_Android"] }
                        else if (Squad.equals("SmokeSuite") && Platform.equals("iOS")) { return["SmokeSuite_iOS"] }
                    '''
                ]
            ]
        ],
        [
            $class: 'CascadeChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            name: 'BuildPackage',
            description: 'Selected the package',
            referencedParameters: 'Platform,TestEnv',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: true,
                    script: 'return["Disabled"]'
                ],
                script: [
                    classpath: [],
                    sandbox: true,
                    script: '''
                        import groovy.json.JsonSlurper

                        def nexus_url = ""

                        if (Platform.equals("Android") && TestEnv.equals("Dev")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/andriod/dev&sort=name&direction=desc"
                        } else if (Platform.equals("Android") && TestEnv.equals("VIT")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/andriod/vit&sort=name&direction=desc"
                        } else if (Platform.equals("Android") && TestEnv.equals("UAT2")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/andriod/uat2&sort=name&direction=desc"
                        } else if (Platform.equals("iOS") && TestEnv.equals("Dev")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/ios/Dev&sort=name&direction=desc"
                        } else if (Platform.equals("iOS") && TestEnv.equals("VIT")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/ios/VIT&sort=name&direction=desc"
                        } else if (Platform.equals("iOS") && TestEnv.equals("UAT2")) {
                            nexus_url = "https://nexus.tmbbank.local:8081/service/rest/v1/search?repository=One_APP_RAW&group=/mobile/ios/uat2&sort=name&direction=desc"
                        } else { return["Disabled"] }

                        def authString = "oneapp:ad123Tmb*".getBytes().encodeBase64().toString()

                        try {
                            def http_client = new URL(nexus_url).openConnection() as HttpURLConnection
                            http_client.setRequestProperty( "Authorization", "Basic ${authString}" )
                            http_client.setRequestProperty( "Accept", "application/json" )
                            http_client.setRequestMethod('GET')
                            http_client.connect()
                            def nexus_response = [:]
                            if (http_client.responseCode == 200) {
                                nexus_response = new JsonSlurper().parseText(http_client.inputStream.getText('UTF-8'))
                            } else {
                                return [ "HTTP return code:" + http_client.responseCode ]
                            }
                            def package_list = []
                            def package_name = ""
                            nexus_response.items.each { tag_metadata ->
                                package_name = tag_metadata.name.split("/")[3]
                                if (( Platform.equals("Android") && package_name[-3..-1].equals("apk") ) ||
                                    ( Platform.equals("iOS") && package_name[-3..-1].equals("ipa") )) {
                                    package_list.add(package_name)
                                }
                            }
                            if (package_list.size() > 0) {
                                return package_list
                            } else {
                                return [ "No package list" ]
                            }
                        } catch (Exception e) {
                            return [ "Throw exception: " + e ]
                        }
                    '''
                ]
            ]
        ]
    ]
    return parameters
}

def bitbucket = getBitbucketConf()
def nexus = getNexusConf()

properties([
  parameters(getSaucelabsUIParameters())
])

def appName = 'automation-testing'
def branch = 'develop'
def sl_url = 'https://api.us-west-1.saucelabs.com/v1/storage/upload'
def sl_get_url = 'https://api.us-west-1.saucelabs.com/v1/storage/files'
def sl_user = 'tadapee'
def sl_key = 'a031267a-d718-4de8-be23-03def6d8def7'
def build_status = 'SUCCESS'

def test_squad = "${Squad}"
def test_env = "${TestEnv}"
def test_platform = "${Platform}"
def test_xmlfile = "${XmlFiles}.xml"
def test_pkg = "${BuildPackage}"

def formattedCurrentDateTime =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))

//node("oneapp-build") {
node ('MACNEW') {
  def reportName  = "${test_squad}_${test_platform}_${test_env}_${formattedCurrentDateTime}"
  try {

    stage ('Checkout') {
      echo "\n\n\n***************************************************************************************************"
      echo "Automated Testing for:\n\n\t\tSquad: ${test_squad}\n\t\tEnvironment: ${test_env}\n\t\tPlatform: ${test_platform}\n\t\tTestingType: UI\n\t\tXmlFile: ${test_xmlfile}\n\t\tBuild: ${test_pkg}\n\n"
      echo "***************************************************************************************************\n\n\n"

      sh "sudo rm -rf ./code"
      dir ('./code') {
        git branch: "${branch}", credentialsId: "${bitbucket.jenkinsCredentialsId}", url: "${bitbucket.url}/scm/one/${appName}.git"
        if (fileExists("SquadwiseXmlFiles/UI/$test_squad/$test_xmlfile") == false) {
          echo "FAILED: XML test suite does not exist"
          build_status = 'FAILURE'
          sh "exit 1"
        }
      }
    }

    stage ('Upload to Saucelabs') {
      if ( build_status != "SUCCESS" ) {
          Utils.markStageSkippedForConditional('Upload to Saucelabs')
      } else {
        dir ('./code') {
          withCredentials([usernamePassword(credentialsId: "${nexus.jenkinsCredentialsId}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            def package_url = "https://$nexus.url/repository/One_APP_RAW/mobile"
            if (test_platform == "Android" && test_env == "Dev") {
              package_url = "$package_url/andriod/dev/$test_pkg"
            } else if (test_platform == "Android" && test_env == "VIT") {
              package_url = "$package_url/andriod/vit/$test_pkg"
            } else if (test_platform == "Android" && test_env == "UAT2") {
              package_url = "$package_url/andriod/uat2/$test_pkg"
            } else if (test_platform == "iOS" && test_env == "Dev") {
              package_url = "$package_url/ios/Dev/$test_pkg"
            } else if (test_platform == "iOS" && test_env == "VIT") {
              package_url = "$package_url/ios/VIT/$test_pkg"
            } else if (test_platform == "iOS" && test_env == "UAT2") {
              package_url = "$package_url/ios/uat2/$test_pkg"
            }

            try {
              def upload_result = sh (
                script: """
                  echo "Check package in Saucelabs"
                  CONTENT_LENGTH=\$(curl -k -sI -u "$sl_user:$sl_key" --location --request GET "$sl_get_url?q=$test_pkg" | grep content-length | awk '{print \$2}' | sed -e 's/[[:space:]]*\$//')
                  if [[ \$CONTENT_LENGTH -lt 1024 ]]; then
                    echo "Download package from Nexus"
                    curl -k -o $test_pkg -u "$USERNAME:$PASSWORD" $package_url
                    if [ \$? -eq 0 ]; then
                      echo "Upload package to SauceLabs: $test_pkg"
                      curl --silent --output /dev/null --show-error --fail -F "payload=@$test_pkg" -F "name=$test_pkg" -u "$sl_user:$sl_key" $sl_url
                      if [ \$? -eq 0 ]; then
                        echo "Upload to Saucelabs completed"
                        exit 0
                      else
                        echo "Upload to Saucelabs failed"
                        exit 1
                      fi
                    else
                      echo "Download package from Nexus failed: $test_pkg"
                      exit 1
                    fi
                  else
                    echo "Package already uploaded to Saucelabs"
                    exit 0
                  fi
                """, returnStatus: true )
              if (upload_result != 0) {
                build_status = 'FAILURE'
                sh "exit 1"
              }
            } catch (Exception e) {
              catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                build_status = 'FAILURE'
                sh "exit 1"
              }
            }
          }
        }
      }
    }

    stage ('Run automated test') {

      if ( build_status != "SUCCESS" ) {
          Utils.markStageSkippedForConditional('Run automated test')
      } else {
        dir ('./code') {
          timeout (time: 60, unit: 'MINUTES') {
            try {
              sh """#!/bin/bash
                  export JAVA_HOME=`/usr/libexec/java_home -v 11.0.12`
                  MAVEN_CMD="/Users/user/tools/maven-3.8.3/bin/mvn"

                  \$MAVEN_CMD -Dmaven.wagon.http.ssl.insecure=true \
                  -Dmaven.wagon.http.ssl.allowall=true \
                  -DEnvironment="${test_env}" \
                  -DTestingType="UI" \
                  -DSquad="${test_squad}" \
                  -Dsurefire.suiteXmlFiles="SquadwiseXmlFiles/UI/${test_squad}/${test_xmlfile}" \
                  -DoneAppBuild="${test_pkg}" \
                  -DreportName="${reportName}" \
                  clean install test
              """
            } catch (Exception e) {
              catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                build_status = 'FAILURE'
                sh "exit 1"
              }
            }
          }
        }
      }
    }

    stage ('Upload Report') {
      dir ('./code') {
        timeout (time: 60, unit: 'MINUTES') {
              try {
                 sh """#!/bin/bash
                      cd reports/
                      zip -r ${reportName}.zip  ${reportName}.html images
                    """
                 sh """#!/bin/bash
                      curl -v --insecure -u ${nexus.username}:${nexus.password} --upload-file reports/${reportName}.zip https://nexus.tmbbank.local:8081/repository/OneAppReport/ui/${reportName}.zip
                 """
              } catch (Exception e) {
                 catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                   build_status = 'FAILURE'
                   sh "exit 1"
                 }
              }
        }
      }
    }

  } finally {

    stage ('Cleanup') {
      cleanWs()
    }

    if ( build_status != "SUCCESS" ) {
        sh "exit 1"
    }

  }
}