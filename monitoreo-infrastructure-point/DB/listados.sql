INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (0, true, 'NO DEFINIDO', null);
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (1, true, 'CONTINUO', null);
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (2, true, 'HORA', '01:00:00');
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (3, true, 'DÍA', '1 day');
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (4, true, 'SEMANA', '7 days');
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (5, true, 'MES', '1 mon');
INSERT INTO plan_frequency_unit(unid_id, alive, name, "interval") VALUES (6, true, 'AÑO', '1 year');

INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 1, true, 'Continuo', null, 1, 1);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 2, true, 'Horaria', null, 1, 2);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 3, true, 'Diaria', null, 1, 3);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 4, true, 'Cada 48 Horas', null, 2, 3);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 5, true, 'Cada 72 Horas', null, 3, 3);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 6, true, 'Bisemanal', null, 0.5, 4);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 7, true, 'Semanal', null, 1, 4);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 8, true, 'Bimensual', null, 0.5, 5);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 9, true, 'Mensual', null, 1, 5);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 10, true, 'Bimestral', null, 2, 5);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 11, true, 'Trimestral', null, 3, 5);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 12, true, 'Semestral', null, 6, 5);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 13, true, 'Anual', null, 1, 6);
INSERT INTO public.plan_frequency(tena_id, freq_id, alive, name, description, quantity, unid_id) VALUES (1, 14, true, 'No Definido', null, 0, 0);

INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Continuo', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Puntual', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Estratificado', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Sistemático', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Cuadrantes', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Transectos', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true, 'Otro', null);
INSERT INTO public.plan_type(tena_id, alive, name, description) VALUES (1, true,'No Indica', null);

INSERT INTO public.plan_frequency_sma(tena_id, alive, name, description) VALUES (2, true, 'Mensual', null);
INSERT INTO public.plan_frequency_sma(tena_id, alive, name, description) VALUES (2, true, 'Bimestral', null);
INSERT INTO public.plan_frequency_sma(tena_id, alive, name, description) VALUES (2, true, 'Trimestral', null);
INSERT INTO public.plan_frequency_sma(tena_id, alive, name, description) VALUES (2, true, 'Semestral', null);
INSERT INTO public.plan_frequency_sma(tena_id, alive, name, description) VALUES (2, true, 'Anual', null);

INSERT INTO public.task_status_valid(stat_id, name, description) VALUES (1, 'Ok', null);
INSERT INTO public.task_status_valid(stat_id, name, description) VALUES (2, 'Con reparos', null);
INSERT INTO public.task_status_valid(stat_id, name, description) VALUES (3, 'Validada', null);
INSERT INTO public.task_status_valid(stat_id, name, description) VALUES (4, 'Confirmada', null);
INSERT INTO public.task_status_valid(stat_id, name, description) VALUES (5, 'Reanálisis', null);

INSERT INTO public.task_status(tena_id, stat_id, name, description) VALUES (1, 1, 'Ok', null);
INSERT INTO public.task_status(tena_id, stat_id, name, description) VALUES (1, 2, 'Con reparos', null);
INSERT INTO public.task_status(tena_id, stat_id, name, description) VALUES (1, 3, 'Validada', null);
INSERT INTO public.task_status(tena_id, stat_id, name, description) VALUES (1, 4, 'Confirmada', null);
INSERT INTO public.task_status(tena_id, stat_id, name, description) VALUES (1, 5, 'Reanálisis', null);

INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Aguas', null);
INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Aire', null);
INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Fauna', null);
INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Flora', null);
INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Residuos', null);
INSERT INTO public.component(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Olores', null);

INSERT INTO public.parameter_unit(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, '%', null);
INSERT INTO public.parameter_unit(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, '°C', null);
INSERT INTO public.parameter_unit(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'Bq/L', null);
INSERT INTO public.parameter_unit(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'ppm', null);
INSERT INTO public.parameter_unit(tena_id, alive, creation_time, name, description) VALUES (1, true, localtimestamp, 'pH', null);