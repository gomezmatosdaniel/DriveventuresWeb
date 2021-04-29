<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.driveventures.utils.*"%>


<%@include file="/common/header.jsp"%>

<h3>Registro</h3>

<form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.REGISTRO_COCHE%>" /> 
		<input type="text"name="nombre" placeholder="Nombre" /> 
		<input type="number"
		name="anho_creacion" placeholder="Año Creación" /> <input
		type="number" name="plazas" placeholder="Plazas" /> 
		<input type="text" name="matricula" placeholder="Matricula" /> 
		
		<select name="Marca">
		<option value="Alfa Romeo">Alfa Romeo</option>
		<option value="Aston Martin">Aston Martin</option>
		<option value="Audi">Audi</option>

		<option value="Autovaz">Autovaz</option>
		<option value="Bentley">Bentley</option>
		<option value="Bmw">Bmw</option>
		<option value="Cadillac">Cadillac</option>

		<option value="Caterham">Caterham</option>
		<option value="Chevrolet">Chevrolet</option>
		<option value="Chrysler">Chrysler</option>
		<option value="Citroen">Citroen</option>

		<option value="Daihatsu">Daihatsu</option>
		<option value="Dodge">Dodge</option>
		<option value="Ferrari">Ferrari</option>
		<option value="Fiat">Fiat</option>

		<option value="Ford">Ford</option>
		<option value="Honda">Honda</option>
		<option value="Hummer">Hummer</option>
		<option value="Hyundai">Hyundai</option>

		<option value="Isuzu">Isuzu</option>
		<option value="Jaguar">Jaguar</option>
		<option value="Jeep">Jeep</option>
		<option value="Kia">Kia</option>

		<option value="Lamborghini">Lamborghini</option>
		<option value="Lancia">Lancia</option>
		<option value="Land Rover">Land Rover</option>
		<option value="Lexus">Lexus</option>

		<option value="Lotus">Lotus</option>
		<option value="Maserati">Maserati</option>
		<option value="Mazda">Mazda</option>
		<option value="Mercedes Benz">Mercedes Benz</option>

		<option value="MG">MG</option>
		<option value="Mini">Mini</option>
		<option value="Mitsubishi">Mitsubishi</option>
		<option value="Morgan">Morgan</option>

		<option value="Nissan">Nissan</option>
		<option value="Opel">Opel</option>
		<option value="Peugeot">Peugeot</option>
		<option value="Porsche">Porsche</option>

		<option value="Renault">Renault</option>
		<option value="Rolls Royce">Rolls Royce</option>
		<option value="Rover">Rover</option>
		<option value="Saab">Saab</option>

		<option value="Seat">Seat</option>
		<option value="Skoda">Skoda</option>
		<option value="Smart">Smart</option>
		<option value="Ssangyong">Ssangyong</option>

		<option value="Subaru">Subaru</option>
		<option value="Suzuki">Suzuki</option>
		<option value="Tata">Tata</option>
		<option value="Toyota">Toyota</option>

		<option value="Volkswagen">Volkswagen</option>
		<option value="Volvo">Volvo</option>
	</select> 
	
	<select name="modelo">
	
      <option value=1>500</option>
		<option value=2>A4</option>
		<option value=3>F40</option>
		<option value=4>Punto</option>
		
	</select> 
	<input type="hidden" name="user_id" value="${usr.id}" /> 
	<input type="submit" value="registro_coche" name="ConductorServlet" />
</form>

</body>
</html>