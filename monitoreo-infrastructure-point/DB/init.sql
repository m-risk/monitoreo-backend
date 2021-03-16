-- =============================================================================
-- Diagram Name: monitoreo
-- Created on: 24-01-2021 23:59:16
-- Diagram Version: 
-- =============================================================================

CREATE SEQUENCE "pg_def_seq"
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START WITH 1;




CREATE TABLE "plan_frequency" (
	"tena_id" int4 NOT NULL,
	"freq_id" int4 NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"name" varchar(100) NOT NULL,
	"description" text,
	"quantity" float4 NOT NULL,
	"unid_id" int2 NOT NULL,
	CONSTRAINT "frequency_id" PRIMARY KEY("freq_id")
);

CREATE TABLE "plan_frequency_unit" (
	"unid_id" int2 NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"name" varchar(100) NOT NULL,
	"interval" interval(0),
	CONSTRAINT "frequency_unit_id" PRIMARY KEY("unid_id")
);

CREATE TABLE "plan_type" (
	"tena_id" int4 NOT NULL,
	"type_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"name" varchar(100) NOT NULL,
	"description" text,
	PRIMARY KEY("type_id")
);

CREATE TABLE "program" (
	"tena_id" int4 NOT NULL,
	"prog_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"acco_id" int4,
	"name" varchar(250) NOT NULL,
	"description" text,
	PRIMARY KEY("prog_id")
);

CREATE TABLE "point" (
	"tena_id" int4 NOT NULL,
	"poin_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"acco_id" int4 NOT NULL,
	"name" varchar(250) NOT NULL,
	"name_internal" varchar(250) NOT NULL,
	"sect_id" int4 NOT NULL,
	"description" text,
	PRIMARY KEY("poin_id")
);

CREATE TABLE "component" (
	"tena_id" int4 NOT NULL,
	"comp_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"name" varchar(250) NOT NULL,
	"description" text,
	PRIMARY KEY("comp_id")
);

CREATE TABLE "component_sub" (
	"tena_id" int4 NOT NULL,
	"csub_id" SERIAL NOT NULL,
	"alive" bool,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"comp_id" int4 NOT NULL,
	"name" varchar(250) NOT NULL,
	"description" text,
	PRIMARY KEY("csub_id")
);

CREATE TABLE "parameter" (
	"tena_id" int4 NOT NULL,
	"para_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"csub_id" int4 NOT NULL,
	"name" varchar(250) NOT NULL,
	"symbol" varchar(10),
	"unit_id" int4 NOT NULL,
	"discrete" bool NOT NULL DEFAULT False,
	PRIMARY KEY("para_id")
);

CREATE TABLE "parameter_unit" (
	"tena_id" int4 NOT NULL,
	"unit_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"name" varchar(250) NOT NULL,
	"description" text,
	PRIMARY KEY("unit_id")
);

CREATE TABLE "norm" (
	"tena_id" int4 NOT NULL,
	"norm_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"acco_id" int4 NOT NULL,
	"csub_id" int4,
	"name" varchar(250) NOT NULL,
	"legal" bool NOT NULL DEFAULT True,
	"number" varchar(100) NOT NULL,
	"detail" text,
	"date_publication" date NOT NULL,
	"type_id" int4 NOT NULL,
	"organism_issuing_id" int4 NOT NULL,
	"organism_inspector_id" int4 NOT NULL,
	PRIMARY KEY("norm_id")
);

CREATE TABLE "plan" (
	"tena_id" int4 NOT NULL,
	"plan_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"acco_id" int4 NOT NULL,
	"csub_id" int4 NOT NULL,
	"type_id" int4 NOT NULL,
	"freq_id" int4 NOT NULL,
	"norm_id" int4 NOT NULL,
	"prog_id" int4 NOT NULL,
	"name" varchar(250) NOT NULL,
	"valid" bool NOT NULL DEFAULT True,
	"opre_id" int4 NOT NULL,
	"date_start" date NOT NULL,
	"date_end" date NOT NULL,
	"proj_id" int4 NOT NULL,
	"collaborator_acco_id" int4 NOT NULL,
	"validator_acco_id" int4 NOT NULL,
	"assigned_acco_id" int4 NOT NULL,
	"oper_id" int4 NOT NULL,
	"detail" text,
	"etfa" bool NOT NULL DEFAULT False,
	"sma_freq_id" int4 NOT NULL,
	PRIMARY KEY("plan_id")
);

CREATE INDEX "plan_index" ON "plan" (
	"tena_id", 
	"plan_id"
);


CREATE TABLE "plan_point" (
	"plan_id" int4 NOT NULL,
	"poin_id" int4 NOT NULL,
	"tena_id" int4 NOT NULL,
	PRIMARY KEY("plan_id","poin_id")
);

CREATE TABLE "plan_parameter" (
	"plan_id" int4 NOT NULL,
	"para_id" int4 NOT NULL,
	"ion_balance" bool NOT NULL DEFAULT False,
	"tena_id" int4 NOT NULL,
	PRIMARY KEY("plan_id","para_id")
);

CREATE TABLE "plan_frequency_sma" (
	"tena_id" int4 NOT NULL,
	"freq_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"name" varchar(100) NOT NULL,
	"description" text,
	PRIMARY KEY("freq_id")
);

CREATE TABLE "plan_norm" (
	"plan_id" int4 NOT NULL,
	"norm_id" int4 NOT NULL,
	"tena_id" int4 NOT NULL,
	PRIMARY KEY("plan_id","norm_id")
);

CREATE TABLE "norm_parameter" (
	"norm_id" int4 NOT NULL,
	"para_id" int4 NOT NULL,
	"limit_minimum" float4,
	"limit_maximum" float4,
	"tena_id" int4 NOT NULL,
	PRIMARY KEY("norm_id","para_id")
);

CREATE TABLE "norm_type" (
	"tena_id" int4 NOT NULL,
	"type_id" int4 NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"name" varchar(100) NOT NULL,
	"description" text,
	PRIMARY KEY("type_id")
);

CREATE TABLE "task_status" (
	"tena_id" int4 NOT NULL,
	"stat_id" int4 NOT NULL,
	"name" varchar(100) NOT NULL,
	"description" text,
	PRIMARY KEY("stat_id")
);

CREATE TABLE "task_status_valid" (
	"stat_id" int4 NOT NULL,
	"name" varchar(100) NOT NULL,
	"description" text,
	PRIMARY KEY("stat_id")
);

CREATE TABLE "task" (
	"tena_id" int4 NOT NULL,
	"task_id" int4 NOT NULL,
	"plan_id" int4 NOT NULL,
	"stat_id" int4 NOT NULL,
	"out_norm" bool NOT NULL DEFAULT False,
	"historical_range" bool NOT NULL DEFAULT False,
	"quantity" int4 NOT NULL DEFAULT 0,
	"quantity_out_norm" int4 NOT NULL DEFAULT 0,
	"quantity_historical_range" int4 NOT NULL DEFAULT 0,
	PRIMARY KEY("task_id")
);

CREATE TABLE "parameter_unit_parameter" (
	"para_id" int4 NOT NULL,
	"unit_id" int4 NOT NULL,
	"tena_id" int4 NOT NULL,
	PRIMARY KEY("para_id","unit_id")
);

CREATE TABLE "parameter_unit_conversion" (
	"tena_id" int4 NOT NULL,
	"unit_id_origin" int4 NOT NULL,
	"unit_id_destination" int4 NOT NULL,
	"factor" float8 NOT NULL,
	PRIMARY KEY("unit_id_origin","unit_id_destination")
);

CREATE TABLE "data" (
	"tena_id" int4 NOT NULL,
	"data_id" SERIAL NOT NULL,
	"task_id" int4 NOT NULL,
	"para_id" int4 NOT NULL,
	"poin_id" int4,
	"value" float4 NOT NULL,
	"plan_id" int4 NOT NULL,
	"out_norm" bool NOT NULL DEFAULT False,
	"historical_range" bool NOT NULL DEFAULT False,
	"disc_id" int4,
	PRIMARY KEY("data_id")
);

CREATE TABLE "parameter_discrete" (
	"tena_id" int4 NOT NULL,
	"disc_id" SERIAL NOT NULL,
	"alive" bool NOT NULL DEFAULT True,
	"creation_time" timestamp NOT NULL DEFAULT LOCALTIMESTAMP,
	"modification_time" timestamp,
	"destruction_time" timestamp,
	"para_id" int4 NOT NULL,
	"name" varchar(100) NOT NULL,
	"out_norm" bool NOT NULL DEFAULT False,
	PRIMARY KEY("disc_id")
);


ALTER TABLE "plan_frequency" ADD CONSTRAINT "Ref_plan_frequency_to_plan_frequency_unit" FOREIGN KEY ("unid_id")
	REFERENCES "plan_frequency_unit"("unid_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "component_sub" ADD CONSTRAINT "Ref_component_sub_to_component" FOREIGN KEY ("comp_id")
	REFERENCES "component"("comp_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter" ADD CONSTRAINT "Ref_parameter_to_component_sub" FOREIGN KEY ("csub_id")
	REFERENCES "component_sub"("csub_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter" ADD CONSTRAINT "Ref_parameter_to_parameter_unit" FOREIGN KEY ("unit_id")
	REFERENCES "parameter_unit"("unit_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "norm" ADD CONSTRAINT "Ref_norm_to_norm_type" FOREIGN KEY ("type_id")
	REFERENCES "norm_type"("type_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_plan_type" FOREIGN KEY ("type_id")
	REFERENCES "plan_type"("type_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_plan_frequency" FOREIGN KEY ("freq_id")
	REFERENCES "plan_frequency"("freq_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_plan_frequency_sma" FOREIGN KEY ("sma_freq_id")
	REFERENCES "plan_frequency_sma"("freq_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_program" FOREIGN KEY ("prog_id")
	REFERENCES "program"("prog_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_norm" FOREIGN KEY ("norm_id")
	REFERENCES "norm"("norm_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan" ADD CONSTRAINT "Ref_plan_to_component_sub" FOREIGN KEY ("csub_id")
	REFERENCES "component_sub"("csub_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_point" ADD CONSTRAINT "Ref_plan_point_to_point" FOREIGN KEY ("poin_id")
	REFERENCES "point"("poin_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_point" ADD CONSTRAINT "Ref_plan_point_to_plan" FOREIGN KEY ("plan_id")
	REFERENCES "plan"("plan_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_parameter" ADD CONSTRAINT "Ref_plan_parameter_to_plan" FOREIGN KEY ("plan_id")
	REFERENCES "plan"("plan_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_parameter" ADD CONSTRAINT "Ref_plan_parameter_to_parameter" FOREIGN KEY ("para_id")
	REFERENCES "parameter"("para_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_norm" ADD CONSTRAINT "Ref_plan_norm_to_plan" FOREIGN KEY ("plan_id")
	REFERENCES "plan"("plan_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "plan_norm" ADD CONSTRAINT "Ref_plan_norm_to_norm" FOREIGN KEY ("norm_id")
	REFERENCES "norm"("norm_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "norm_parameter" ADD CONSTRAINT "Ref_norm_parameter_to_norm" FOREIGN KEY ("norm_id")
	REFERENCES "norm"("norm_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "norm_parameter" ADD CONSTRAINT "Ref_norm_parameter_to_parameter" FOREIGN KEY ("para_id")
	REFERENCES "parameter"("para_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "task_status" ADD CONSTRAINT "Ref_task_status_to_task_status_valid" FOREIGN KEY ("stat_id")
	REFERENCES "task_status_valid"("stat_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "task" ADD CONSTRAINT "Ref_task_to_task_status" FOREIGN KEY ("stat_id")
	REFERENCES "task_status"("stat_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "task" ADD CONSTRAINT "Ref_task_to_plan" FOREIGN KEY ("plan_id")
	REFERENCES "plan"("plan_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter_unit_parameter" ADD CONSTRAINT "Ref_parameter_unit_parameter_to_parameter" FOREIGN KEY ("para_id")
	REFERENCES "parameter"("para_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter_unit_parameter" ADD CONSTRAINT "Ref_parameter_unit_parameter_to_parameter_unit" FOREIGN KEY ("unit_id")
	REFERENCES "parameter_unit"("unit_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter_unit_conversion" ADD CONSTRAINT "Ref_parameter_unit_conversion_origin_to_parameter_unit" FOREIGN KEY ("unit_id_origin")
	REFERENCES "parameter_unit"("unit_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter_unit_conversion" ADD CONSTRAINT "Ref_parameter_unit_conversion_destination_to_parameter_unit" FOREIGN KEY ("unit_id_destination")
	REFERENCES "parameter_unit"("unit_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "data" ADD CONSTRAINT "Ref_data_to_task" FOREIGN KEY ("task_id")
	REFERENCES "task"("task_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "data" ADD CONSTRAINT "Ref_data_to_plan_parameter" FOREIGN KEY ("plan_id", "para_id")
	REFERENCES "plan_parameter"("plan_id", "para_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "data" ADD CONSTRAINT "Ref_data_to_plan_point" FOREIGN KEY ("plan_id", "poin_id")
	REFERENCES "plan_point"("plan_id", "poin_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "data" ADD CONSTRAINT "Ref_data_to_parameter_discrete" FOREIGN KEY ("disc_id")
	REFERENCES "parameter_discrete"("disc_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "parameter_discrete" ADD CONSTRAINT "Ref_parameter_discrete_to_parameter" FOREIGN KEY ("para_id")
	REFERENCES "parameter"("para_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;


