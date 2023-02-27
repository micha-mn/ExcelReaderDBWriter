  $("#submit").click(function() {
	  
	  	  	 $("#result").empty();
			  const file = $("input[type='file']")[0].files[0];
			  const formData = new FormData();
			  formData.append("file", file);
			  const rateLimit = $("#rateLimit").val();
  			  formData.append("rateLimit", rateLimit);
  			  const periodOne = $("#periodOne").val();
  			  formData.append("periodOne", periodOne);
  			  const periodTwo = $("#periodTwo").val();
  			  formData.append("periodTwo", periodTwo);
  			  const periodThree = $("#periodThree").val();
  			  formData.append("periodThree", periodThree);
  			  
			  $.ajax({
			    url: "/read",
			    type: "POST",
			    data: formData,
			    processData: false,
			    contentType: false,
			    success: function(response) {
					
					$("#result").css("color","black");
					$("#result").css("background","#00e7b8");
					$("#result").css("margin-top","1rem");
					$("#result").append("File uploaded successfully!");
					
			    },
			    error: function(error) {
			     	$("#result").css("color","black");
					$("#result").css("background","red");
					$("#result").css("margin-top","1rem");
					$("#result").append(error.responseJSON.message);
			    }
			  });
	  
	  });