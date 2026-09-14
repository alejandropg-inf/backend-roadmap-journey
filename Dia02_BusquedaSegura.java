import java.util.HashMap;

public class Dia02_BusquedaSegura {
    public static void main(String[] args) {

        // 1. Cola inicial
        HashMap<String, Integer> colaTareas = new HashMap<>();
        colaTareas.put("transcribe_audio", 10);
        colaTareas.put("render_720p", 4);
        colaTareas.put("generate_subtitles", 7);

        // 2. Consulta segura con getOrDefault
        int tareas4k = colaTareas.getOrDefault("upscale_4k", 0);
        System.out.println("Tareas upscale_4k pendientes: " + tareas4k);

        // 3. Procesar tarea existente con containsKey
        if (colaTareas.containsKey("transcribe_audio")) {
            int actuales = colaTareas.get("transcribe_audio");
            colaTareas.put("transcribe_audio", actuales - 3);
            System.out.println("Tareas transcribe_audio actualizadas: " + colaTareas.get("transcribe_audio"));
        } else {
            System.out.println("Error: Tipo de tarea no soportado.");
        }

        // 4. Intentar procesar tarea inexistente
        if (colaTareas.containsKey("watermark_removal")) {
            int actuales = colaTareas.get("watermark_removal");
            colaTareas.put("watermark_removal", actuales - 1);
        } else {
            System.out.println("Error: Tipo de tarea 'watermark_removal' no registrado.");
        }

        System.out.println("--- ESTADO FINAL DE LA COLA ---");

        // 5. Reporte final recorriendo con for-each
        for (String tarea : colaTareas.keySet()) {
            int pendientes = colaTareas.get(tarea);
            System.out.println("[EN COLA] Tipo: " + tarea + " | Pendientes: " + pendientes);
        }
    }
}