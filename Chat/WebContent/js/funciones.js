var x = $(document);
	x.ready(inicializar);
	
	function inicializar(){
                cargarMensajes();
                verUsersOnline();
		var x = $("#btnIngresar");
		x.click(formIngresar);
		x = $("#btnRegistrarse");
		x.click(formRegistrar);
		x=$("#formuIng");
		x.submit(cargarIng);
                x=$("#formuReg");
                x.submit(cargarReg);
                x = $("#btnIngresar2");
                x.click(noIngresar);
                x = $("#btnRegistrarse2");
                x.click(noRegistrar);
                x = $("#enviarMSJ");
                x.click(enviarMensaje);
                x = $("#txtMensaje");
                x.keypress(enviarMSJ);
	}
        
        function enviarMSJ(event){
            if(event.which == 13){
                enviarMensaje();
                event.preventDefault();
                
            }
        }
        
        function verUsersOnline(){
            var x = $("#usersOnline");
            x.load("verUsers.jsp",function(){
                setTimeout("verUsersOnline()",1000);
            });
        }
        
         function enviarMensaje(){
            var x = $("#txtMensaje").val();
            
            $.ajax({
							  type: "POST",
							  url:"enviarmensaje.jsp",
							  beforeSend: inicioCargaMSJ,
							  data:'mensaje='+x,
							  success:llegadaMSJ,
							  error:problemasMSJ
							}); 
            $("#txtMensaje").val("");
            $("#txtMensaje").focus();
        }
        
        function inicioCargaMSJ(){
            var x = $("#ventanaConversacionInt");
            x.append("<img src='img/ajaxMsj.gif' id='imgLoad' style='display:block;'>");
            irAlUltimo();
        }
        
        function llegadaMSJ(datos){
            var z= $("#imgLoad");
            z.fadeTo("slow",0);
            z.remove();
            var x = $("#ventanaConversacionInt");
            cargarMensajes();
        }
        
        function problemasMSJ(){
            alert("Problemas con el Servidor");
        }

        
        function cargarMensajes(){
            var x = $("#ventanaConversacionInt");
            x.load("cargarmensajes.jsp", function(){irAlUltimo();
                setTimeout("cargarMensajes()",1000);
            
        });
            
        }
        
        function irAlUltimo(){
            var x = $("#ventanaConversacionInt");
            x.scrollTo("#ultimo",0);
        }
        
        function noIngresar(){
            alert("Ya Ingresaste");
        }
        function noRegistrar(){
            alert("Ya estas registrado");
        }
        
        //REgistro de usuarios
        
        function cargarReg(event){
		event.preventDefault();
		var x = $("#nombreReg").val();
		var z = $("#passwordReg").val();
		$.ajax({
							  type: "POST",
							  url:"registrar.jsp",
                                                          dataType: "html",
							  beforeSend: inicioCargaReg,
							  data:'nombre='+x+'&password='+z,
							  success:llegadaReg,
							  error:problemasReg
							}); 
	}
        
        function problemasReg(problema){
		var x = $("#respuestaReg");
		x.html(problema);
	}
	
	function inicioCargaReg(){
		var x = $("#respuestaReg");
		x.html("<img src='img/ajaxReg.gif'/>");
	}
	
	function llegadaReg(datos){
		var x = $("#respuestaReg");
		x.html(datos);
	}
        
        //FIN CARGA REGISTRO
        //Ingreso de Usuario BD
        
        function cargarIng(event){
		event.preventDefault();
		var x = $("#nombreIng").val();
		var z = $("#passwordIng").val();
		$.ajax({
                                                          type: "POST",
                                                          url:"login.jsp",
                                                           beforeSend: inicioCargaIng,
							  data:'nombre='+x+'&password='+z,
							  success:llegadaIng,
							  error:problemasIng
							}); 
	}
	
	function problemasIng(problema){
		var x = $("#respuestaIng");
		x.html(problema);
	}
	
	function inicioCargaIng(){
		var x = $("#respuestaIng");
		x.html("<img src='img/ajaxIng.gif'/>");
	}
	
	function llegadaIng(datos){
		var x = $("#respuestaIng");
		x.html(datos);
	}
        // FIN INGRESO LLEGADA USUARIOS
        
       
	function formIngresar(){
		var x = $("#ingresar");
		x.dialog({height: 250, width:350,maxHeight:250,maxWidth:350,minHeight:250,minWidth:350,show:"fade",hide:"explode"});
		x.fadeTo(2000,1,function(x){x.css("display","block");});
		
		x = $("#registrar");
		x.dialog("destroy");
	}
	
	function formRegistrar(){
		var x = $("#registrar");
		x.dialog({height: 250, width:350,maxHeight:250,maxWidth:350,minHeight:250,minWidth:350,show:"fade",hide:"explode"});
		x.fadeTo(2000,1,function(x){x.css("display","block");});
		
		x = $("#ingresar");
		x.dialog("destroy");
	}// JavaScript Document