# Vanhack Shortener

A docker image is available: `docker pull vithinholm/vanhackshortner`

To shorten the URL call **/short** using the link parameter with the URL to be shortened.

For example localhost/short?link=google.com

Shortened links counter available at /counter.

To run this project use `docker-compose up -d` and will be started the mysql and this project

To execute the container use: 
`docker run -p 0.0.0.0:80:8080/tcp vithinholm/vanhackshortner`

In your browser just enter `http://localhost` and test the API or try with Postman