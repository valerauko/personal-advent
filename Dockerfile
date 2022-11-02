FROM nginx:1.23.2-alpine

WORKDIR /usr/share/nginx/html

RUN mkdir -p css js
COPY public/css/ui.css css/ui.css
COPY public/js/app.js js/app.js
COPY public/index.html index.html
