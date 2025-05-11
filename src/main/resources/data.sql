CREATE OR REPLACE TYPE venta_rec IS OBJECT (
    id_venta    NUMBER,
    valor_venta NUMBER
);
/
CREATE OR REPLACE TYPE venta_tabla IS TABLE OF venta_rec;
/
-- Función que retorna la colección
CREATE OR REPLACE FUNCTION obtener_ventas_empleado(
    p_id_empleado IN NUMBER
) RETURN venta_tabla PIPELINED AS
BEGIN
    FOR r IN (
        SELECT id_venta, valor_venta
        FROM ventas
        WHERE id_empleado = p_id_empleado
    ) LOOP
        PIPE ROW(venta_rec(r.id_venta, r.valor_venta));
    END LOOP;
    RETURN;
END obtener_ventas_empleado;
/