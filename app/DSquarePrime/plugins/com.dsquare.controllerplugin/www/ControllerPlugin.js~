var exec = require('cordova/exec');
function ControllerPlugin() { console.log("ControllerPlugin.js: is created");
}
ControllerPlugin.prototype.saveState = function(aString,id,state,intensity,loc){ console.log("ControllerPlugin.js: saveState"); exec(function(result){ /*alert("OK" + reply);*/ }, function(result){ /*alert("Error" + reply);*/ },"ControllerPlugin",aString,[id, state, intensity, loc]);
};
ControllerPlugin.prototype.saveMood = function(aString,preferedState){ console.log("ControllerPlugin.js: saveMood"); exec(function(result){ /*alert("OK" + reply);*/ }, function(result){ /*alert("Error" + reply);*/ },"ControllerPlugin",aString,[preferedState]);
}; 
ControllerPlugin.prototype.reloadData = function(aString){ console.log("ControllerPlugin.js: reloadData"); exec(
function(result){ 

//var resultObj1 = jQuery.parseJSON( result );
//$('#logo').html(result);
$.each($.parseJSON(result), function(idx, resultObj) {
	
	if(parseInt(resultObj.id)<5){
			$('#dimmer'+resultObj.id+'-slider').slider('setValue',resultObj.intensity);
			$('#dimmer'+resultObj.id+'-slider-perc').html(resultObj.intensity);
			if(resultObj.state==="1"){
				$('#dimmer'+resultObj.id+'-slider-bulb').attr('src','./images/bulb-on.png');
				//$("#companyName").html($("#companyName").html()+" - data in if - "); 
			}
			else if(resultObj.state==="0"){
				$('#dimmer'+resultObj.id+'-slider-bulb').attr('src','./images/bulb-off.png') 
			}
			//dataToSend = [123, 1, 20, 20-1];
			//$("#companyName").html($("#companyName").html()+" - data - ");
			/*bluetoothSerial.write(dataToSend, function(){
      	 $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	 $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });*/
		/*var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[1]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[2]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[3]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });			
			*/
			
		}
		else{
			if(resultObj.state==="1"){
				if($('#bulb'+resultObj.id+'-Switch-img').attr('src') 
				&& $('#bulb'+resultObj.id+'-Switch-img').attr('src')=="./images/bulb-off.png"){
					$('#bulb'+resultObj.id+'-Switch').click();					
					$('#bulb'+resultObj.id+'-Switch-img').attr('src','./images/bulb-on.png');
				}
				
			}
			else if(resultObj.state==="0"){
				if($('#bulb'+resultObj.id+'-Switch-img').attr('src') 
				&& $('#bulb'+resultObj.id+'-Switch-img').attr('src')=="./images/bulb-on.png"){
					$('#bulb'+resultObj.id+'-Switch').click();					
					$('#bulb'+resultObj.id+'-Switch-img').attr('src','./images/bulb-off.png');
				}
			}
		}
}); //for each ends
	count = 6;
    	dimmer1 = parseInt($('#dimmer1-slider-perc').html());
    	dimmer2 = parseInt($('#dimmer2-slider-perc').html());
    	dimmer3 = parseInt($('#dimmer3-slider-perc').html());
    	dimmer4 = parseInt($('#dimmer4-slider-perc').html());
    	switch1 = 0;
    	if($('#bulb5-Switch-img').attr('src') && $('#bulb5-Switch-img').attr('src')=="./images/bulb-on.png"){switch1 = 100;}else{switch1 = 0;}
    	switch2 = 0;
    	if($('#bulb6-Switch-img').attr('src') && $('#bulb6-Switch-img').attr('src')=="./images/bulb-on.png"){switch2 = 100;}else{switch2 = 0;}
    	
    	burning = (dimmer1+dimmer2+dimmer3+dimmer4+switch1+switch2);
    	burningPerc = 0;
    	maxBurning = 100;
    	if(parseInt(burning) == 0 || parseInt(count) == 0){
    		burningPerc = 0;
    		maxBurning = 100;
    	}
    	else{
    		burningPerc = burning/count;
    	}
    	$('#energySaving').html(parseInt(maxBurning-burningPerc)+'%');
}, 
function(result){ /*alert("Error" + reply);*/ },"ControllerPlugin",aString,[]);
};
ControllerPlugin.prototype.setMood = function(aString){ console.log("ControllerPlugin.js: setMood"); exec(
function(result){ 

//var resultObj1 = jQuery.parseJSON( result );
//$('#logo').html(result);
$.each($.parseJSON(result), function(idx, resultObj) {
	var bulbId = parseInt(resultObj.id);
		var intensity = parseInt(resultObj.intensity); 
		var dataToSend = [123, bulbId, intensity, intensity-bulbId];
	if(parseInt(resultObj.id)<5){
		
			$('#dimmer'+bulbId+'-slider').slider('setValue',intensity);
			$('#dimmer'+bulbId+'-slider-perc').html(intensity);
			if(resultObj.state==="1"){
				$('#dimmer'+bulbId+'-slider-bulb').attr('src','./images/bulb-on.png') 
			}
			else if(resultObj.state==="0"){
				$('#dimmer'+bulbId+'-slider-bulb').attr('src','./images/bulb-off.png') 
			}
			
			
			bluetoothSerial.write([dataToSend[0]], function(){
			//$("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
			// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[1]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[2]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[3]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });		
		}
		else{
			if(resultObj.state==="1"){
				if($('#bulb'+resultObj.id+'-Switch-img').attr('src') 
				&& $('#bulb'+resultObj.id+'-Switch-img').attr('src')=="./images/bulb-off.png"){
					$('#bulb'+resultObj.id+'-Switch').click();					
					$('#bulb'+resultObj.id+'-Switch-img').attr('src','./images/bulb-on.png');
				}
				
			}
			else if(resultObj.state==="0"){
				if($('#bulb'+resultObj.id+'-Switch-img').attr('src') 
				&& $('#bulb'+resultObj.id+'-Switch-img').attr('src')=="./images/bulb-on.png"){
					$('#bulb'+resultObj.id+'-Switch').click();					
					$('#bulb'+resultObj.id+'-Switch-img').attr('src','./images/bulb-off.png');
				}
			}
			
			bluetoothSerial.write([dataToSend[0]], function(){
			//$("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
			// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[1]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[2]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > 30){
      break;
    }
  }
		bluetoothSerial.write([dataToSend[3]], function(){
      	// $("#companyName").html($("#companyName").html()+" - written - ");
      }, function(){
      	// $("#companyName").html($("#companyName").html()+" - failed to write - ");
      });
		}
		
      	
});//for each ends
	count = 6;
    	dimmer1 = parseInt($('#dimmer1-slider-perc').html());
    	dimmer2 = parseInt($('#dimmer2-slider-perc').html());
    	dimmer3 = parseInt($('#dimmer3-slider-perc').html());
    	dimmer4 = parseInt($('#dimmer4-slider-perc').html());
    	switch1 = 0;
    	if($('#bulb5-Switch-img').attr('src') && $('#bulb5-Switch-img').attr('src')=="./images/bulb-on.png"){switch1 = 100;}else{switch1 = 0;}
    	switch2 = 0;
    	if($('#bulb6-Switch-img').attr('src') && $('#bulb6-Switch-img').attr('src')=="./images/bulb-on.png"){switch2 = 100;}else{switch2 = 0;}
    	
    	burning = (dimmer1+dimmer2+dimmer3+dimmer4+switch1+switch2);
    	burningPerc = 0;
    	maxBurning = 100;
    	if(parseInt(burning) == 0 || parseInt(count) == 0){
    		burningPerc = 0;
    		maxBurning = 100;
    	}
    	else{
    		burningPerc = burning/count;
    	}
    	$('#energySaving').html(parseInt(maxBurning-burningPerc)+'%');
}, 
function(result){ /*alert("Error" + reply);*/ },"ControllerPlugin",aString,[]);
};
ControllerPlugin.prototype.allOff = function(aString, count){ console.log("ControllerPlugin.js: allOff"); exec(function(result){ /*alert("OK" + reply);*/ }, function(result){ /*alert("Error" + reply);*/ },"ControllerPlugin",aString,[count]);
};
var controllerPlugin = new ControllerPlugin(); module.exports = controllerPlugin;
