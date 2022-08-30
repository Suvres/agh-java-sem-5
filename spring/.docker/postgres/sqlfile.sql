--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO suvres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: rating; Type: TABLE; Schema: public; Owner: suvres
--

CREATE TABLE public.rating (
    id integer NOT NULL,
    rate integer NOT NULL,
    course_id integer NOT NULL,
    comment character varying(255),
    date timestamp without time zone
);


ALTER TABLE public.rating OWNER TO suvres;

--
-- Name: rating_seq; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.rating_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rating_seq OWNER TO suvres;

--
-- Name: student; Type: TABLE; Schema: public; Owner: suvres
--

CREATE TABLE public.student (
    index integer NOT NULL,
    condition integer NOT NULL,
    email character varying(255),
    birth_day character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL
);


ALTER TABLE public.student OWNER TO suvres;

--
-- Name: student_c_c_seq; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.student_c_c_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_c_c_seq OWNER TO suvres;

--
-- Name: student_c_seq; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.student_c_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_c_seq OWNER TO suvres;

--
-- Name: student_course; Type: TABLE; Schema: public; Owner: suvres
--

CREATE TABLE public.student_course (
    id integer NOT NULL,
    group_name character varying(255),
    max_students_count double precision,
    container_id integer
);


ALTER TABLE public.student_course OWNER TO suvres;

--
-- Name: student_course_container; Type: TABLE; Schema: public; Owner: suvres
--

CREATE TABLE public.student_course_container (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.student_course_container OWNER TO suvres;

--
-- Name: student_mark; Type: TABLE; Schema: public; Owner: suvres
--

CREATE TABLE public.student_mark (
    id integer NOT NULL,
    date timestamp without time zone,
    mark double precision,
    course_id integer,
    student_id integer
);


ALTER TABLE public.student_mark OWNER TO suvres;

--
-- Name: student_mark_seq; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.student_mark_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_mark_seq OWNER TO suvres;

--
-- Name: student_seq; Type: SEQUENCE; Schema: public; Owner: suvres
--

CREATE SEQUENCE public.student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_seq OWNER TO suvres;

--
-- Data for Name: rating; Type: TABLE DATA; Schema: public; Owner: suvres
--

COPY public.rating (id, rate, course_id, comment, date) FROM stdin;
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: suvres
--

COPY public.student (index, condition, email, birth_day, first_name, last_name) FROM stdin;
1	1	asd@asd.pl	12-12-2000	Adam	Test
2	1	test@test.pl	12-12-2020	Test1	Test2
3	1	test@test.pl	12-12-2020	Test1	Test2
4	1	test@test.pl	12-12-2020	Test1	Test2
6	1	test@test.pl	12-12-2020	Test1	Test2
9	1	test@test.pl	12-12-2020	Test1	Test2
10	1	test@test.pl	12-12-2020	123	1
11	1	test@test.pl	12-12-2020	Test1	Test2
13	1	test@test.pl	12-12-2020	Test1	Test2
15	1	test@test.pl	12-12-2020	Test1	Test2
17	1	test@test.pl	12-12-2020	Test1	Test2
19	1	test@test.pl	12-12-2020	Test1	Test2
21	1	test@test.pl	12-12-2020	Test1	Test2
23	1	test@test.pl	12-12-2020	Test1	Test2
25	1	test@test.pl	12-12-2020	Test1	Test2
27	1	test@test.pl	12-12-2020	Test1	Test2
29	1	test@test.pl	12-12-2020	Test1	Test2
33	1	test@test.pl	12-12-2020	Test1	Test2
35	1	test@test.pl	12-12-2020	Test1	Test2
37	1	test@test.pl	12-12-2020	Test1	Test2
46	1	test@test.pl	12-12-2020	Test1	Test2
48	1	test@test.pl	12-12-2020	Test1	Test2
49	1	test@test.pl	12-12-2020	Test1	Test2
50	1	test@test.pl	12-12-2020	Test1	Test2
51	1	test@test.pl	12-12-2020	Test1	Test2
52	1	test@test.pl	12-12-2020	Test1	Test2
53	1	test@test.pl	12-12-2020	Test1	Test2
54	1	test@test.pl	12-12-2020	Test1	Test2
55	1	test@test.pl	12-12-2020	Test1	Test2
56	1	test@test.pl	12-12-2020	Test1	Test2
57	1	test@test.pl	12-12-2020	Test1	Test2
58	1	test@test.pl	12-12-2020	Test1	Test2
59	1	test@test.pl	12-12-2020	Test1	Test2
\.


--
-- Data for Name: student_course; Type: TABLE DATA; Schema: public; Owner: suvres
--

COPY public.student_course (id, group_name, max_students_count, container_id) FROM stdin;
1	java	12	1
2	Nowa-dwa	10	1
3	\N	10	1
4	\N	0	1
\.


--
-- Data for Name: student_course_container; Type: TABLE DATA; Schema: public; Owner: suvres
--

COPY public.student_course_container (id, name) FROM stdin;
1	it
\.


--
-- Data for Name: student_mark; Type: TABLE DATA; Schema: public; Owner: suvres
--

COPY public.student_mark (id, date, mark, course_id, student_id) FROM stdin;
1	2022-01-01 11:17:58	4	1	1
2	2022-01-02 11:18:17	4.5	1	1
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 8, true);


--
-- Name: rating_seq; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.rating_seq', 1, false);


--
-- Name: student_c_c_seq; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.student_c_c_seq', 1, false);


--
-- Name: student_c_seq; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.student_c_seq', 4, true);


--
-- Name: student_mark_seq; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.student_mark_seq', 1, false);


--
-- Name: student_seq; Type: SEQUENCE SET; Schema: public; Owner: suvres
--

SELECT pg_catalog.setval('public.student_seq', 59, true);


--
-- Name: rating pk_rating; Type: CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.rating
    ADD CONSTRAINT pk_rating PRIMARY KEY (id);


--
-- Name: student pk_student; Type: CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT pk_student PRIMARY KEY (index);


--
-- Name: student_course_container student_course_container_pkey; Type: CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_course_container
    ADD CONSTRAINT student_course_container_pkey PRIMARY KEY (id);


--
-- Name: student_course student_course_pkey; Type: CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT student_course_pkey PRIMARY KEY (id);


--
-- Name: student_mark student_mark_pkey; Type: CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_mark
    ADD CONSTRAINT student_mark_pkey PRIMARY KEY (id);


--
-- Name: rating fk1u7bgpeaixlv0gsfq5rxv5jgc; Type: FK CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fk1u7bgpeaixlv0gsfq5rxv5jgc FOREIGN KEY (course_id) REFERENCES public.student_course(id);


--
-- Name: student_course fk2641xcdh41yg1lssfp1fgm43y; Type: FK CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_course
    ADD CONSTRAINT fk2641xcdh41yg1lssfp1fgm43y FOREIGN KEY (container_id) REFERENCES public.student_course_container(id);


--
-- Name: student_mark fkhptia2stkuf8mlwdlgudnb0ff; Type: FK CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_mark
    ADD CONSTRAINT fkhptia2stkuf8mlwdlgudnb0ff FOREIGN KEY (student_id) REFERENCES public.student(index);


--
-- Name: student_mark fkid4ardn5mwdpimfbhorowkpxk; Type: FK CONSTRAINT; Schema: public; Owner: suvres
--

ALTER TABLE ONLY public.student_mark
    ADD CONSTRAINT fkid4ardn5mwdpimfbhorowkpxk FOREIGN KEY (course_id) REFERENCES public.student_course(id);


--
-- PostgreSQL database dump complete
--

