
/**
 * 
 * @param message
 */
function WebSocketTest(message)
{
  if ("WebSocket" in window)
  {
     alert("WebSocket is supported by your Browser!");
     // Let us open a web socket
     var ws = new WebSocket("ws://localhost:9111");
     ws.onopen = function()
     {
        // Web Socket is connected, send data using send()
    	console.log("message : "+message);
        ws.send(message);
     };
     ws.onmessage = function (evt) 
     { 
        var received_msg = evt.data;
        document.getElementById("serverMessageReceived").innerHTML = received_msg;
     };
     ws.onclose = function()
     { 
        // websocket is closed.
    	 console.log("Connection is closed..."); 
     };
  }
  else
  {
     // The browser doesn't support WebSocket
     alert("WebSocket NOT supported by your Browser!");
  }
}