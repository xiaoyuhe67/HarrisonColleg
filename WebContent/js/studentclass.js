$(document).ready(function() {
	
	
	$('.Dropclass').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(9);
		 var dataString ='classid='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "StudentClassServlet",
           data: dataString,
           success: function(data){
        	   alert("Drop the class successfully!");
               window.location = 'http://localhost:8080/HarrisonCollege/studentclass.jsp';
             }                
			  });
		 
		 
	 
});            
	
	$('.Sendemail').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(9);
		 var dataString ='email='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "Sendemail",
          data: dataString,
          success: function(data){
       	   alert("Send Email to instructor successfully!");
              window.location = 'http://localhost:8080/HarrisonCollege/studentclass.jsp';
            }                
			  });
		 
		 
	 
});  		 	
	 
	             
		  
	
});
