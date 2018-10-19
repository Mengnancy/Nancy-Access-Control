```
location ^~/access {
            rewrite ^/access/(.*)$ /$1 break;
            proxy_pass http://localhost:8081;
        }

        location / {
            root   html;
            index  index.html index.htm;
            proxy_pass   http://localhost:8080;
        }
```