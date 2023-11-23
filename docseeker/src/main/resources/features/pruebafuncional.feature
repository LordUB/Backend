Feature: DockSecker - Sistema de Gestión de Atención Médica

  Background:
    Given que estoy en la ventana principal de DockSecker

  Scenario: Ingresar como paciente y agendar una cita exitosamente

    When ingreso como paciente
    Then veo el menú principal con opciones para gestionar mi atención médica

    When selecciono la opción "Buscar Doctor"
    Then se despliega una lista de doctores con información detallada

    When elijo al Doctor John Doe, un cardiólogo con 15 años de experiencia, 40 años de edad, $100 por consulta y graduado en la Universidad Médica de Prestigio
    Then veo su perfil con detalles como pacientes atendidos, años de experiencia, edad, costo por consulta y lugar de graduación

    And reviso las reseñas de otros pacientes
    Then decido que el doctor cumple con mis necesidades y procedo con la agendación de la cita

    When agendo una cita para el 15 de noviembre a las 3:00 PM
    Then se me presenta una lista de horarios disponibles y un botón para proceder al pago

    When selecciono el horario deseado y procedo al pago
    Then se abre una ventana para realizar el pago vía tarjeta de crédito

    When completo el pago con la opción de guardar los datos de la tarjeta
    Then recibo una confirmación detallada de la cita agendada y el pago realizado, con información como número de confirmación, detalles de la cita y recibo digital

  Scenario: Revisar reseñas antes de agendar una cita

    When ingreso como paciente
    Then veo el menú principal con opciones para gestionar mi atención médica

    When selecciono la opción "Buscar Doctor"
    Then se despliega una lista de doctores con información detallada

    When elijo al Doctor No Tan Bien Reseñado, un cardiólogo con 5 años de experiencia, 35 años de edad, $80 por consulta y graduado en una universidad reconocida
    Then veo su perfil con detalles como pacientes atendidos, años de experiencia, edad, costo por consulta y lugar de graduación

    And reviso las reseñas de otros pacientes
    Then determino que las reseñas no son satisfactorias para mis necesidades

    When decido volver al menú de selección de doctores
    Then regreso al menú principal para elegir otro doctor

    And salgo de la aplicación