# Spring-Boot-Api-Web-App
Instructions

Step 1: Download and run a docker rabbitmq image:

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management

Step 2: Download elastic search via https://www.elastic.co/downloads/elasticsearch

Step 3: Open elasticsearch folder and navigate to /config/ and open elasticsearch.yml

Edit the cluster name to: cluster.name: entry-cluster

Edit the path to where you have cloned this project: C:\Users\User\coding-challenge

Step 4: Import the project into your IDE and run.

API Instructions

Step 1. Authenticate yourself by using POST to localhost:8080/authenticate with JSON body 
{
	"username":"admin"
	"password":"jacobsecretkey"
}

Step 2. Copy returned JWT token and past it in Header
eg: Header - > Key:'Authorization' Value:"Bearer {Insert Token Here}"
Make sure you add 'Bearer ' before the token inside Value:

example: Key: 'Authorization' Value: 'Bearer 213hjcdn09i1233un2okd329021ensdfok'


Step3. Once your authorization token has been placed in the Header
Use one of the following methods:


a)POST locahost:8080/entries - Add entry
It takes 3 fields.
(You can specify EntryId but it will generate one automatically.)

{
        "date": "12-23-1998",
        "text": "jaco2323b",
        "attachment": "123123"
}

b)GET localhost:8080/entries - View all entries


Code comments:

Date
I made date a string primitive instead of a Date/LocalDateTime because I was encountering conversion errors with rabbitmq.
Error message:Unable to convert value X to java.time.LocalDateTime for property 'date'

JSON doesnt have a DATE type so to store a date variable within elastic, you have to specify a String.
This also ensured i could use a MM-DD-YYYY format.
https://www.elastic.co/guide/en/elasticsearch/reference/current/date.html

Attachment:

This is most likely due to my ignorance but I have no idea howto properly store binary data within elastic, I tried using byte[] array but it doesnt really convert the file into useful data that can be read.
The best solution I came up with is just to base64 encode the file and store it in a String with elastics Binary field type.

Notes:
ElasticSearch is hosted on locahost:9200, the cluster is on localhost:9200/entry
RabbitMQ is hosted on localhost:15672 if you ran the command above.

jwt functionality author:
Jwt authentication was implemented by using this guide/code https://www.javainuse.com/spring/boot-jwt
