
Simple Login task done using retrofit + MVP + Butter Knife 


User can login by Email / Password

There is Login Button 

Data Conditions:

Email :

Field type: Text

Mandatory: Yes

Update: Yes

Business rules: Email Validation

Allowed symbols: Email format only


Password :

Field type: Text.

Mandatory: Yes.

Update: Yes.

Allowed symbols: Letters, spaces, numbers and symbols.

Login Button :

Field type: Button

Mandatory: Yes

The API Used is a POST method 
https://private-d3105-tamini.apiary-mock.com/Tamini/login

The  Request Body is
            {
                "email": " ",
                "password" :"12345"
            }
,And the Response Body is
            {
                "status": true,
                "error": 0,
                "message": "Login Success"
            }

