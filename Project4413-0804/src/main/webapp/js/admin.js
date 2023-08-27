function clickme(id){
	const loadButton = document.getElementById("detailBtn"+id);
   


	const ordId = id;
        //const url = './AdminViewController?ordId='+id;
        
        var xhttp = new XMLHttpRequest();
        var url = "./AdminViewController";
        var data='';
         data +="?id=";
         data +=id;
         
       data += "&comm=ajax";
        
        console.log("button id = "+ordId);
        
         xhttp.onreadystatechange = function() { 
        if (xhttp.readyState == 4 && xhttp.status == 200) { 
//	console.log("reached 200 and 4");
	
	var jsonResponse = JSON.parse(xhttp.responseText);
	 console.log(jsonResponse);
	 
	 populateTable(jsonResponse);
	
	 }else{
		console.log("failed");
	}
	};
        
        
        xhttp.open("GET", url+data, true); 
		xhttp.send();
       
       
      
    
    }
    
    
      function populateTable(data) {
      
 		const orderTableBody = document.querySelector("#orderDetails tbody");
 		  orderTableBody.innerHTML = ""; // Clear previous data
 		  
 		var a = data.orderID;
 		var b = data.itemList;
 		var c = data.qtyList;
 		var d = data.priceList;
 		var e = data.total;
 		
 		const row = orderTableBody.insertRow();
 		
 		const OrderId = row.insertCell(0);
            const ItemList = row.insertCell(1);
            const QuantityList = row.insertCell(2);
             const PriceList = row.insertCell(3);
           const Total = row.insertCell(4);
            
            OrderId.textContent = a;
            ItemList.textContent = b;
            PriceList.textContent = d;
            QuantityList.textContent = c;
            Total.textContent = e;
 		
       
    }
