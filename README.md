# Vällkomnen till mitt skolprojekt databaser med Spring JPA.

För att använda detta korrekt behöver du postman samt skriva in på ett korrekt sätt.
Lista alla kanaler:
Get
localhost:8080/channel

Lista specifika kanaler och se meddelanden från den kanalen:
Get
localhost:8080/channel/{id}
Id på kanalen.

Lägga till en ny kanal
Post
localhost:8080/channel
{
    "channelDescription": "",
    "channelName": "",
    "message": "" 
}
Ta bort en kanal
Delete
localhost:8080/channel/{id}
Id på kanalen.

Lägga till ett meddelande
Post
localhost:8080/messages/{id}
id på  kanalen.
{
    "channelDescription": "",
    "channelName": "",
    "message": "" ,
    "NewMessage": ""
}

Uppdatera ett meddelande
Put
localhost:8080/messages/update/{id}
id på meddelandet.
Syntax som tex "Another message": "text", eller liknande.

Ta bort ett meddelande
Delete
localhost:8080/messages/{id}
id på meddelandet.
