<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            color: #007bff; /* Blue color for the title */
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
        }

        form {
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background for form */
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: grid;
            grid-template-columns: 1fr 1fr; /* Landscape layout */
            gap: 15px;
            max-width: 70%;
            box-sizing: border-box;
        }

        label {
            grid-column: span 1;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="number"],
        input[type="submit"] {
            grid-column: span 1;
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            outline: none;
            box-sizing: border-box;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus,
        input[type="number"]:focus {
            border-color: #007bff; 
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        input[type="submit"] {
            padding: 12px;
            background-color: #007bff; 
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0062cc;
        }
    </style>
</head>
<body>

    <h2>User Registration Form</h2>

    <form action="RegisterController" method="post">
        <label for="accNo">Account Number:</label>
        <input type="number" id="accNo" name="accNo" required />

        <label for="accBal">Account Balance:</label>
        <input type="number" step="0.01" id="accBal" name="accBal" required />

        <label for="branchCity">Branch City:</label>
        <input type="text" id="branchCity" name="branchCity" required />

        <label for="IFSCcode">IFSC Code:</label>
        <input type="text" id="IFSCcode" name="IFSCcode" required />

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />

        <label for="PhoneNo">Phone Number:</label>
        <input type="number" id="PhoneNo" name="PhoneNo" required />

        <label for="City">City:</label>
        <input type="text" id="City" name="City" required />

        <input type="submit" value="Register" />
    </form>
</body>
</html>