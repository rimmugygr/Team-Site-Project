##1_step
#FROM node:latest as node
#WORKDIR /app
#COPY . .
#RUN npm install
#RUN npm run build --prod
##2_step
#FROM nginx:alpine
#COPY --from=node /app/dist/team-frontend /user/share/nginx/html

FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY dist/team-frontend /usr/share/nginx/html


###use_comand
#ng build --prod
#docker build .
#docker build -t client-image .
#docker run --name client-container -d -p 4200:80 client-image
#docker run -p 80:80 'image_id'
#docker rmi 'image_id' -f
#docker rmi -f $(docker images)
