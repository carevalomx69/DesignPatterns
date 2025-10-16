ServicioTerceroPago servicioExistente = new ServicioTerceroPago();

// ESTO PROVOCARÁ UN ERROR DE COMPILACIÓN:
// RealizarAccionesPago espera IPagoNuevo, pero recibe ServicioTerceroPago.
// RealizarAccionesPago(servicioExistente, 50.00m);
