  
  $( document ).ready(function() {
	   
	   //  getSavedDBConfig();
	     
	});
	
	 $("#upload").click(function() {
		 
		 
		     $("#uploadLoader").removeClass("d-none");
		   	 $("#result").empty();
			  const file = $("input[type='file']")[0].files[0];
			if (typeof file === "undefined") 
			 {      $("#uploadLoader").addClass("d-none");
				    $("#result").css("color","white");
					$("#result").css("background","#dc3545");
					$("#result").css("margin-top","1rem");
					$("#result").append("File is required!");
					return;
			 }
			  const formData = new FormData();
			  formData.append("file", file);
  			  const periodOne = $("#periodOne").val();
  			  formData.append("periodOne", periodOne);
  			  const periodTwo = $("#periodTwo").val();
  			  formData.append("periodTwo", periodTwo);
  			  
			  $.ajax({
			    url: "/read",
			    type: "POST",
			    data: formData,
			    processData: false,
			    contentType: false,
			    success: function(response) {
					
				    $("input[type='file']").val('');
					$("#uploadLoader").addClass("d-none");
					$("#result").css("color","white");
					$("#result").css("background","#32bcbb");
					$("#result").css("margin-top","1rem");
					$("#result").append("Uploaded successfully!");
					
			    },
			    error: function(error) {
			     	$("#result").css("color","white");
					$("#result").css("background","#dc3545");
					$("#result").css("margin-top","1rem");
					$("#result").append(error.responseJSON.message);
			    }
			  });
		 
		 });  
     $("#startJob").click(function() {
		 
		 $("#startJob").addClass("d-none");
		 $("#stopJob").removeClass("d-none");
		 $("#loader").removeClass("d-none");
		 
		  
	 });
	 $("#stopJob").click(function() {
		 
		  $("#stopJob").addClass("d-none");
		  $("#loader").addClass("d-none");
		  $("#startJob").removeClass("d-none");
	 });
	    
	  function getSavedDBConfig(){
		   
	     $.ajax({
			    url: "/getdbconfig",
			    processData: false,
			    contentType: false,
			    success: function(response) {
					$("#rateLimit").val(response.rateLimit);
					$("#periodOne").val(response.periodOne);
					$("#periodTwo").val(response.periodTwo);
					$("#periodThree").val(response.periodThree);
					},
					 error: function(error) {
			    	 console.log(error);
			    	}
			  });
	  }