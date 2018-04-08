# Spring Cloud config
1. 启动config-server-git
    访问http://localhost:1201/config-client/dev/master
    ```json
    {
        "name": "config-client",
        "profiles": [
            "dev"
        ],
        "label": "master",
        "version": null,
        "state": null,
        "propertySources": [
            {
                "name": "http://git.oschina.net/didispace/config-repo-demo/config-client-dev.yml",
                "source": {
                    "info.profile": "dev"
                }
            },
            {
                "name": "http://git.oschina.net/didispace/config-repo-demo/config-client.yml",
                "source": {
                    "info.profile": "default"
                }
            }
        ]
    }
    ```

2. 启动config-client
    
    访问http://localhost:2001/info 

    返回：
    ```json
    {
        "profile": "default"
    }
    ```