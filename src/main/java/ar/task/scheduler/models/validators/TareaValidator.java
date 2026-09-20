package ar.task.scheduler.models.validators;

import java.time.LocalDateTime;

public class TareaValidator extends PlantillaValidator {

	private static final String MSG_DATE = "La fecha y hora";
	private static final String MSG_INVALID_DATE_TIME = "La fecha no puede ser anterior a hoy y ahora";

	public static LocalDateTime fechaValidator(LocalDateTime fecha) {
		if (fecha == null) {
			throw new IllegalArgumentException(String.format(MSG_DATE, MSG_ERROR_NULL_EMPTY));
		}

		if (fecha.isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException(MSG_INVALID_DATE_TIME);
		}
		return fecha;
	}

}
