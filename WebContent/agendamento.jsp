<%@page import="br.ucsal.unimed.dominio.Agenda"%>
<%@page import="br.ucsal.unimed.regras.MedicoBO"%>
<%@page import="br.ucsal.unimed.tui.UnimedTUI"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Agendamento</title>

<!-- Bootstrap -->
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/bootstrap-datepicker3.min.css" rel="stylesheet">

<script src="resource/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="resource/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="resource/js/bootstrap-datepicker.pt-BR.min.js" charset="UTF-8"></script>

</head>
<body>
	<div class="container">
		<p>
		<h1>Marcar Consulta</h1>
		<p>
			<br>
		<div class="row">
			<div class="col-md-7">
				<form class="form-horizontal" action="AgendamentoServlet"
					method="post">
					<div class="form-group">
						<label for="medico">Medico</label> <input type="text"
							class="form-control" id="medico" name="nomeMedico"
							placeholder="Digite o Nome do Medico">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-info btn-lg">Buscar</button>
					</div>
				</form>
			</div>
		</div>
		<%
			MedicoBO medicoBO = (MedicoBO) request.getAttribute("medicoBO");
			if (medicoBO == null) {
				String erro = (String) request.getAttribute("erro");
				if (erro != null && !erro.trim().equals("")) {
					out.print(erro);
				}
			} else {
				out.print("<b>Medico: </b>" + medicoBO.getMedico().getNome());
				
				out.print("<br>Datas disponiveis :");
				for(Agenda agenda : medicoBO.getAgenda()){
					System.out.print(agenda.getData().toString());
				}

			}
		%>
		<br> <br>
		<div class="row">
			<div class="col-md-3">
				<form class="form-horizontal">
					<div class="form-group">
						<label for="data-escolhida" class="col-sm-2 control-label">Data:</label>
						<div class="col-sm-10">
							<div class="input-group date">
								<input type="text" class="form-control" id="data-escolhida"
									placeholder="Selecione a Data" name="data-escolhida">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-th"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">Selecionar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$('#data-escolhida').datepicker({
			format : 'dd/mm/yyyy',
			language : "pt-BR",
			startDate : '+0',
			daysOfWeekDisabled : "0,6"
		});
	</script>

</body>
</html>