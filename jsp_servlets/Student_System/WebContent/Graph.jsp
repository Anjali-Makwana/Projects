<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/d3/3.4.6/d3.min.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.css" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/c3/0.1.29/c3.js"></script>
</head>
<body>

<div id="chart"></div>
<script type="text/javascript">
var modData = new Array();

d3.json("graphController", function(data) {
	 
	  data.forEach(function(k) {
	    graphItem = new Array();
	    graphItem.push(k.teacherName);
	    
	    	graphItem.push(k.grade);
	    	
	    modData.push(graphItem);
	  });
	  
	 
});




	  var chart = c3.generate({
		  bindto: '#chart',
		    data: {
		        type:'bar',
		        columns: modData
		        
		    },
		    
		    size: { height: 500, width: 1000 }  
		  });  

	  setTimeout(function () {
		    chart.load({
		        columns: [
		            ['teacher1', 1,2,3],
		            ['teacher2', 3,6,2],
		            ['teacher3', 5,8,9]
		            
		        ]
		    });
		}, 1000);
	  
	 
</script> 
</body>
</html>