    function checkLogin() {
         var userLog = document.getElementById("checkLogin").innerHTML;
     
      if(userLog ==="")
    	  {
    	  document.getElementById("showLogin").style.display = "none";
    	 
    	  }
      else
    	  {
    	  document.getElementById("showLogin").style.display = "block";
    	  
    	  }
    	 
      
         }
    
    function checkRegOptions() {
        var userLog2 = document.getElementById("checkLogin").innerHTML;
    
     if(userLog2 ==="")
   	  {
   	  document.getElementById("loginOptions").style.display = "block";
   	 
   	  }
     else
   	  {
   	  document.getElementById("loginOptions").style.display = "none";
   	  
   	  }
   	 
     
        }
    
    
    
    function showReview() {
    	  var x = document.getElementById("review");
    	  var user = document.getElementById("user").innerHTML;
    	  var sign = document.getElementById("signIN");
    	  if(user === "")
    		  {
    		  sign.style.display = "block"
    		  
    		  }
    	  else
    		  {
    	  
    		  
    		  	if (x.style.display === "block") {
    		  			x.style.display = "none";
    		  	} else {
    		  		x.style.display = "block";
    		  		}
    		  }
    	}
    
    function showKnob() {
  	  var x = document.getElementById("knob");
  	  var user = document.getElementById("user").innerHTML;
  	  var sign = document.getElementById("signIN2");
  	  if(user === "")
  		  {
  		  sign.style.display = "block"
  		  
  		  }
  	  else
  		  {
  	  
  		  
  		  	if (x.style.display === "block") {
  		  			x.style.display = "none";
  		  	} else {
  		  		x.style.display = "block";
  		  		}
  		  }
  	}
    
 
    			 
    			 