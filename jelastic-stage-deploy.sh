#!/bin/bash

jelastic_api_url='app.jpc.infomaniak.com'
env_name='boutique-service-stage'


login() {

	echo "=============================== Login to provider ==============================="
    
    SESSION=$(curl -s "https://$jelastic_api_url/1.0/users/authentication/rest/signin?login=$JELASTIC_USR&password=$JELASTIC_PASS" | \
        sed -E 's/^.*"session":"([^"]+)".*$/\1/')
    [ -n "$SESSION" ] || {
        log "Failed to login with credentials supplied"
        exit 0
    }
	
	echo "=============================== Login end ==============================="
}

deploy_stage() {
    
    echo "=============================== DEPLOY TO STAGE $env_name | $(date +%d.%m.%y_%H-%M-%S) ==============================="

        

        curl -s "https://$jelastic_api_url/1.0/environment/deployment/rest/builddeployproject?delay=1&envName=maven&session=35ex0e8baeaa2b22267d23a10d9657f2773e&nodeid=4280&projectid=$env_name&isSequential=false" >> "$LOG"

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
