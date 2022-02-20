For Testing purpose


1. For add URL will be "http://localhost:8080/student/add"
	Given Input:
	{
	"name":"Shyam Rathore",
	"address":"C-2/7 Dewas Road Police Line,Ujjain"
	}
	
	Expected Output:
	
	{
    "success": true,
    "isException": false,
    "isError": false,
    "hasResult": true,
    "exception": "",
    "error": "",
	"result": {
        "rollNumber":1,
        "name": "Shyam Rathore",
        "address": "C-2/7 Dewas Road Police Line,Ujjain",
        "valid": true
    }
	}
	
	Note:"Roll number is auto incremented for adding a record you don't need to given roll number otherwise it will give error 'Invalid Student' "

	
2. For updating URL will be "http://localhost:8080/student/update"
	Given Input:
	
	{
	"rollNumber":3,
	"name":"Sunidhi Chouhan",
	"address":"C-8/9 Nagjhiri Road Bapu Nagar,Ujjain"
	}
	
	Expected Output:
	
	
	{
    "success": true,
    "isException": false,
    "isError": false,
    "hasResult": true,
    "exception": "",
    "error": "",
    "result": {
        "rollNumber": 3,
        "name": "Sunidhi Chouhan",
        "address": "C-8/9 Nagjhiri Road Bapu Nagar,Ujjain",
        "valid": true
    }
	}
	


3. For deleting the record URL will be "http://localhost:8080/student/delete?rollNumber=2"
	Given Input:
	you need add query string parameter named as "rollNumber" and give its value
	http://localhost:8080/student/delete?rollNumber=2
	
	Expected Output:
	{
    "success": true,
    "isException": false,
    "isError": false,
    "hasResult": true,
    "exception": "",
    "error": "",
    "result": null
	}
	
	
4. For getting list of all data URL will be  "http://localhost:8080/student/getAll"
	Given Input:
	Just hit the above URL and you will get list of the data
	
	Expected Output:
	{
    "success": true,
    "isException": false,
    "isError": false,
    "hasResult": true,
    "exception": "",
    "error": "",
    "result": [
        {
            "rollNumber": 4,
            "name": "Shivani Sharma",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 5,
            "name": "Namra Warsi",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 6,
            "name": "Ritesh Shakya",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 7,
            "name": "Jon reeves",
            "address": "some address",
            "valid": true
        },
        {
            "rollNumber": 8,
            "name": "Jhon marshall",
            "address": "some address1",
            "valid": true
        },
        {
            "rollNumber": 9,
            "name": "Yeng chneg pun",
            "address": "some address2",
            "valid": true
        },
        {
            "rollNumber": 10,
            "name": "Shyam Rathore",
            "address": "C-2/7 Dewas Road Police Line,Ujjain",
            "valid": true
        }
	]
	}
	
5. For searching in the records URL will be "http://localhost:8080/student/search?query=police"

	Given Input: You need add query string parameter named as "query" and give its value
	http://localhost:8080/student/search?query=police
	
	Expected Output:
	
	{
    "success": true,
    "isException": false,
    "isError": false,
    "hasResult": true,
    "exception": "",
    "error": "",
    "result": [
        {
            "rollNumber": 4,
            "name": "Shivani Sharma",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 5,
            "name": "Namra Warsi",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 6,
            "name": "Ritesh Shakya",
            "address": "C-2/7 Dewas Road Police Line Ujjain",
            "valid": true
        },
        {
            "rollNumber": 10,
            "name": "Shyam Rathore",
            "address": "C-2/7 Dewas Road Police Line,Ujjain",
            "valid": true
        }
    ]
	}
	
	
	
