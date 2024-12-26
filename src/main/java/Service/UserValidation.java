package Service;

public class UserValidation {
	

	   
	        // Retrieve user input
	        int accNo = Integer.parseInt(request.getParameter("accNo"));
	        String email = request.getParameter("email");
	        long phoneNo = Long.parseLong(request.getParameter("phoneNo"));

	        boolean isValid = false;

	        try (Connection connection = DatabaseUtil.getConnection()) {
	            // Query to validate account number, email, and phone number
	            String query = "SELECT COUNT(*) FROM Account WHERE accNo = ? AND email = ? AND PhoneNo = ?";
	            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	                pstmt.setInt(1, accNo);
	                pstmt.setString(2, email);
	                pstmt.setLong(3, phoneNo);

	                ResultSet rs = pstmt.executeQuery();
	                if (rs.next() && rs.getInt(1) > 0) {
	                    isValid = true; // Record exists
	                }
	            }

	            if (isValid) {
	                // If valid, proceed with registration or other logic
	                response.getWriter().println("Validation Successful! Account exists in the database.");
	            } else {
	                // If not valid, reject the input
	                response.getWriter().println("Validation Failed! Account Number, Email, or Phone Number does not match.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("An error occurred during validation.");
	        }
	    }
	}

}
