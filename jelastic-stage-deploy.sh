#!/bin/bash

jelastic_api_url='app.jpc.infomaniak.com'
project_id='boutique-service-stage'
env_name='maven'
node_id='4280'



login() {

	echo "=============================== Login to provider ==============================="
    
    SESSION=$(curl -s "https://$jelastic_api_url/1.0/users/authentication/rest/signin?login=$JELASTIC_USR&password=$JELASTIC_PASS" | \
        sed -E 's/^.*"session":"([^"]+)".*$/\1/')
    [ -n "$SESSION" ] || {
        echo "Failed to login with credentials supplied"
        exit 0
    }
    
    echo "Login ok, session:$SESSION"
    
	
	echo "=============================== Login end ==============================="
}

deploy_stage() {
    
    echo "=============================== DEPLOY TO STAGE $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="

		echo "Deploy to provider:$jelastic_api_url, with env:$env_name, projectId:$project_id, nodeId:$node_id"
        
        curl -s "https://$jelastic_api_url/1.0/environment/deployment/rest/builddeployproject?delay=1&envName=$env_name&session=$SESSION&nodeid=$node_id&projectid=$project_id&isSequential=false" >> "$LOG"
		
		echo "Deploy command send"

    echo "=============================== DEPLOY END $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="
}

wait_about_env() {
	echo "=============================== WAITING ABOUT ENV $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="
	
	echo "sleeping 10 second to deploy" 
	sleep 10
	echo "sleep end"
	
	echo "=============================== WAITING ABOUT ENV END $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="
	
}

login
deploy_stage
wait_about_env
