--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: tws_storage; Type: SCHEMA; Schema: -; Owner: tws_server
--

CREATE SCHEMA tws_storage;


ALTER SCHEMA tws_storage OWNER TO tws_server;

--
-- Name: tws_storage2; Type: SCHEMA; Schema: -; Owner: tws_server
--

CREATE SCHEMA tws_storage2;


ALTER SCHEMA tws_storage2 OWNER TO tws_server;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: databasechangelog; Type: TABLE; Schema: public; Owner: tws_server
--

CREATE TABLE databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


ALTER TABLE databasechangelog OWNER TO tws_server;

--
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: tws_server
--

CREATE TABLE databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE databasechangeloglock OWNER TO tws_server;

--
-- Name: element_size_amount; Type: TABLE; Schema: public; Owner: tws_server
--

CREATE TABLE element_size_amount (
    id bigint NOT NULL,
    element_id bigint NOT NULL,
    size_id bigint NOT NULL,
    amount integer NOT NULL
);


ALTER TABLE element_size_amount OWNER TO tws_server;

SET search_path = tws_storage, pg_catalog;

--
-- Name: color; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE color (
    id bigint NOT NULL,
    name character varying
);


ALTER TABLE color OWNER TO tws_server;

--
-- Name: color_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE color_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE color_id_seq OWNER TO tws_server;

--
-- Name: color_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE color_id_seq OWNED BY color.id;


--
-- Name: comments; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE comments (
    id bigint NOT NULL,
    comment character varying,
    user_name character varying,
    user_email character varying,
    element_id bigint,
    creation_date timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE comments OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: element_picture; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_picture (
    element_id bigint NOT NULL,
    picture_id bigint NOT NULL
);


ALTER TABLE element_picture OWNER TO tws_server;

--
-- Name: element_size_amount; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_size_amount (
    id bigint NOT NULL,
    element_id bigint NOT NULL,
    size_id bigint NOT NULL,
    amount integer NOT NULL
);


ALTER TABLE element_size_amount OWNER TO tws_server;

--
-- Name: element_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    gender character varying(255) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    color bigint,
    type bigint NOT NULL,
    is_deleted boolean DEFAULT true,
    price numeric DEFAULT 0 NOT NULL,
    components character varying(255)
);


ALTER TABLE element_table OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE element_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE element_table_id_seq OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE element_table_id_seq OWNED BY element_table.id;


--
-- Name: picture_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE picture_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    picture bytea NOT NULL,
    element_id bigint
);


ALTER TABLE picture_table OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE picture_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE picture_table_id_seq OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE picture_table_id_seq OWNED BY picture_table.id;


--
-- Name: size_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE size_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE size_table OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE size_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE size_table_id_seq OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE size_table_id_seq OWNED BY size_table.id;


--
-- Name: type_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE type_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE type_table OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE type_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE type_table_id_seq OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE type_table_id_seq OWNED BY type_table.id;


--
-- Name: users; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    name character varying(255),
    surname character varying(255),
    phone character varying(255),
    user_role character varying(255)
);


ALTER TABLE users OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


SET search_path = tws_storage2, pg_catalog;

--
-- Name: color_table; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE color_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    gradient character varying(255) NOT NULL
);


ALTER TABLE color_table OWNER TO tws_server;

--
-- Name: color_table_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE color_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE color_table_id_seq OWNER TO tws_server;

--
-- Name: color_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE color_table_id_seq OWNED BY color_table.id;


--
-- Name: comments; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE comments (
    id bigint NOT NULL,
    comment character varying,
    user_name character varying,
    user_email character varying,
    element_id bigint,
    creation_date timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE comments OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: element_picture; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE element_picture (
    element_id bigint NOT NULL,
    picture_id bigint NOT NULL
);


ALTER TABLE element_picture OWNER TO tws_server;

--
-- Name: element_table; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE element_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    comments bigint[],
    gender character varying(255) NOT NULL,
    creation_date timestamp without time zone DEFAULT now() NOT NULL,
    size bigint NOT NULL,
    color bigint,
    type bigint NOT NULL,
    amount integer NOT NULL,
    pictures bigint[],
    price numeric DEFAULT 0 NOT NULL,
    components character varying(255)
);


ALTER TABLE element_table OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE element_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE element_table_id_seq OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE element_table_id_seq OWNED BY element_table.id;


--
-- Name: picture_table; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE picture_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    picture bytea NOT NULL,
    element_id bigint
);


ALTER TABLE picture_table OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE picture_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE picture_table_id_seq OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE picture_table_id_seq OWNED BY picture_table.id;


--
-- Name: size_table; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE size_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE size_table OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE size_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE size_table_id_seq OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE size_table_id_seq OWNED BY size_table.id;


--
-- Name: type_table; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE type_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE type_table OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE type_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE type_table_id_seq OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE type_table_id_seq OWNED BY type_table.id;


--
-- Name: users; Type: TABLE; Schema: tws_storage2; Owner: tws_server
--

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    name character varying(255),
    surname character varying(255),
    phone character varying(255),
    user_role character varying(255)
);


ALTER TABLE users OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: tws_storage2; Owner: tws_server
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage2; Owner: tws_server
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


SET search_path = tws_storage, pg_catalog;

--
-- Name: color id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY color ALTER COLUMN id SET DEFAULT nextval('color_id_seq'::regclass);


--
-- Name: comments id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: element_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table ALTER COLUMN id SET DEFAULT nextval('element_table_id_seq'::regclass);


--
-- Name: picture_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY picture_table ALTER COLUMN id SET DEFAULT nextval('picture_table_id_seq'::regclass);


--
-- Name: size_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table ALTER COLUMN id SET DEFAULT nextval('size_table_id_seq'::regclass);


--
-- Name: type_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table ALTER COLUMN id SET DEFAULT nextval('type_table_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


SET search_path = tws_storage2, pg_catalog;

--
-- Name: color_table id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY color_table ALTER COLUMN id SET DEFAULT nextval('color_table_id_seq'::regclass);


--
-- Name: comments id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: element_table id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_table ALTER COLUMN id SET DEFAULT nextval('element_table_id_seq'::regclass);


--
-- Name: picture_table id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY picture_table ALTER COLUMN id SET DEFAULT nextval('picture_table_id_seq'::regclass);


--
-- Name: size_table id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY size_table ALTER COLUMN id SET DEFAULT nextval('size_table_id_seq'::regclass);


--
-- Name: type_table id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY type_table ALTER COLUMN id SET DEFAULT nextval('type_table_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- Name: databasechangeloglock pk_databasechangeloglock; Type: CONSTRAINT; Schema: public; Owner: tws_server
--

ALTER TABLE ONLY databasechangeloglock
    ADD CONSTRAINT pk_databasechangeloglock PRIMARY KEY (id);


SET search_path = tws_storage, pg_catalog;

--
-- Name: element_size_amount element_size_amount_pkey; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT element_size_amount_pkey PRIMARY KEY (id);


--
-- Name: color id_pk; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY color
    ADD CONSTRAINT id_pk PRIMARY KEY (id);


--
-- Name: comments pk_comments; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT pk_comments PRIMARY KEY (id);


--
-- Name: element_table pk_element_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT pk_element_table PRIMARY KEY (id);


--
-- Name: picture_table pk_picture_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY picture_table
    ADD CONSTRAINT pk_picture_table PRIMARY KEY (id);


--
-- Name: size_table pk_size_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT pk_size_table PRIMARY KEY (id);


--
-- Name: type_table pk_type_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT pk_type_table PRIMARY KEY (id);


--
-- Name: users pk_users; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY users
    ADD CONSTRAINT pk_users PRIMARY KEY (id);


--
-- Name: size_table size_name_unique; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT size_name_unique UNIQUE (name);


--
-- Name: type_table type_name_unique; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT type_name_unique UNIQUE (name);


SET search_path = tws_storage2, pg_catalog;

--
-- Name: color_table color_name_unique; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY color_table
    ADD CONSTRAINT color_name_unique UNIQUE (name);


--
-- Name: color_table pk_color_table; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY color_table
    ADD CONSTRAINT pk_color_table PRIMARY KEY (id);


--
-- Name: comments pk_comments; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT pk_comments PRIMARY KEY (id);


--
-- Name: element_table pk_element_table; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT pk_element_table PRIMARY KEY (id);


--
-- Name: picture_table pk_picture_table; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY picture_table
    ADD CONSTRAINT pk_picture_table PRIMARY KEY (id);


--
-- Name: size_table pk_size_table; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT pk_size_table PRIMARY KEY (id);


--
-- Name: type_table pk_type_table; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT pk_type_table PRIMARY KEY (id);


--
-- Name: users pk_users; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY users
    ADD CONSTRAINT pk_users PRIMARY KEY (id);


--
-- Name: size_table size_name_unique; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT size_name_unique UNIQUE (name);


--
-- Name: type_table type_name_unique; Type: CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT type_name_unique UNIQUE (name);


SET search_path = tws_storage, pg_catalog;

--
-- Name: element_table fk_el_type; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT fk_el_type FOREIGN KEY (type) REFERENCES type_table(id);


--
-- Name: element_size_amount fk_element_size_amount__element; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT fk_element_size_amount__element FOREIGN KEY (element_id) REFERENCES element_table(id);


--
-- Name: element_size_amount fk_element_size_amount__size; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT fk_element_size_amount__size FOREIGN KEY (size_id) REFERENCES size_table(id);


--
-- Name: element_picture fk_ep_element; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_element FOREIGN KEY (element_id) REFERENCES element_table(id);


--
-- Name: element_picture fk_ep_picture; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_picture FOREIGN KEY (picture_id) REFERENCES picture_table(id);


SET search_path = tws_storage2, pg_catalog;

--
-- Name: element_table fk_el_size; Type: FK CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT fk_el_size FOREIGN KEY (size) REFERENCES size_table(id);


--
-- Name: element_table fk_el_type; Type: FK CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT fk_el_type FOREIGN KEY (type) REFERENCES type_table(id);


--
-- Name: element_picture fk_ep_element; Type: FK CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_element FOREIGN KEY (element_id) REFERENCES element_table(id);


--
-- Name: element_picture fk_ep_picture; Type: FK CONSTRAINT; Schema: tws_storage2; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_picture FOREIGN KEY (picture_id) REFERENCES picture_table(id);


--
-- PostgreSQL database dump complete
--

