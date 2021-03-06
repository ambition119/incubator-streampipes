# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FROM nginx

COPY dist/assets/img/ /usr/share/nginx/html/assets/img/
COPY dist/assets/css/ /usr/share/nginx/html/assets/css/
COPY dist/assets/lib/ /usr/share/nginx/html/assets/lib/
COPY dist/assets/templates/ /usr/share/nginx/html/assets/templates/
COPY dist/assets/fonts/ /usr/share/nginx/html/assets/fonts/
COPY dist/index.html /usr/share/nginx/html/
COPY dist/main.bundle.js /usr/share/nginx/html/
COPY dist/main.bundle.js.gz /usr/share/nginx/html/
COPY dist/polyfills.bundle.js /usr/share/nginx/html/
COPY dist/polyfills.bundle.js.gz /usr/share/nginx/html/
#COPY dist/runtime.bundle.js /usr/share/nginx/html/
COPY dist/style.bundle.js /usr/share/nginx/html/
COPY dist/style.bundle.js.gz /usr/share/nginx/html/
COPY dist/style.css /usr/share/nginx/html/
COPY dist/style.css.gz /usr/share/nginx/html/

#COPY javadoc/ /usr/share/nginx/html/javadoc

COPY nginx_config/nginx.conf /etc/nginx/nginx.conf
COPY nginx_config/default.conf /etc/nginx/conf.d/default.conf
COPY nginx_config/ssl.conf /app/nginx-confs/ssl.conf

COPY docker-entrypoint.sh /

RUN chown -R nginx:nginx /usr/share/nginx/html/

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]