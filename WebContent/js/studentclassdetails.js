$(document).ready(function() {
	
	
	$('.Dropclass').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(9);
		 var dataString ='classid='+ id;
		 $.ajax({  
			    type: "POST",  
			    url: "Dropclass",
           data: dataString,
           success: function(data){
        	   alert("Drop the class successfully!");
               window.location = 'http://localhost:8080/HarrisonCollege/studentclassdetails.jsp';
             }                
			  });
		
	 
	 
});            
	$('.Enrollclass').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var dataString ='classid='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Enrollclass",
          data: dataString,
          success: function(data){
        	  alert("Enrollclass successfully!");
              window.location = 'http://localhost:8080/HarrisonCollege/studentclassdetails.jsp';
            }                
			  });
	}); 
		 
		
	 
	             
		  
	
});
