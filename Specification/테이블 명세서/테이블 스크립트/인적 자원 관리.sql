--������
create sequence seq_mbr_idx;
create sequence seq_mbr_sn start with 100;

--���̺�
create table tb_mbr (
    idx number not null,
    mbr_sn varchar2(20) not null,
    mbr_nm varchar2(50) not null,
    mbr_enm varchar2(50) not null,
    mbr_birth date,
    mbr_tel varchar2(200), 
    mbr_phone varchar2(200) not null,
    mbr_em varchar2(200),
    mbr_fax varchar2(200),
    mbr_addr_bx varchar2(200) not null,
    mbr_addr_dtl varchar2(100),
    mbr_addr_post varchar2(10) not null,
    mbr_dep_cd varchar2(6) not null,
    mbr_hired_d date,
    mbr_fired_d date,
    mbr_id varchar2(50) not null,
    mbr_pw varchar2(20) not null,
    mbr_cls_cd varchar2(6),
    mbr_main_task varchar2(200),
    mbr_dis varchar2(50),
    mbr_vtr varchar2(3),
    spare1 varchar2(255),
    spare2 varchar2(255),
    spare3 varchar2(255),
    spare4 varchar2(255),
    rgtr_id varchar2(50) not null,
    rgtr_dt date not null,
    mdfr_id varchar2(50),
    mdfr_dt date
    );

--���̺� ��������
alter table tb_mbr add constraint tb_mbr_pk primary key (idx, mbr_nm);
alter table tb_mbr add constraint tb_mbr_sn_uk unique(mbr_sn);
--alter table tb_mbr add constraint tb_mbr_sn_fk foreign key (mbr_sn) references employee (eno); --�ܷ�Ű

--�����ͻ���
insert into tb_mbr (
    idx, mbr_sn, mbr_nm, mbr_enm,
    mbr_tel, mbr_phone, mbr_em,
    mbr_addr_bx, mbr_addr_post,
    mbr_dep_cd, mbr_hired_d,
    mbr_id, mbr_pw, mbr_cls_cd,
    rgtr_id, rgtr_dt) values 
    (seq_mbr_idx.nextval, '20200907'||seq_mbr_sn.nextval, '����ȯ', 'OhJongHwan',
    '7400', ' 010-6678-2273', 'ojh22@naver.com', '����Ư���� ���ʱ� ������27�� 29(���絿, �������)', '137-890',
    'GENAFF', '2020/09/07', 
    'dhwhdghks', 'whdghks4268', 'GAAM01',
    'administrator', '2020/09/05'
    );

--��������ȸ
select * from tb_mbr;
delete from tb_mbr;

commit;
show user;

 -- tb_atd ����------------------------------------------------------------------------------------------------------------------------------
create table tb_atd (
    idx         number      not null,
    atd_nm      varchar2(50) not null,
    atd_sn      varchar2(20),
    atd_gw      date,
    atd_lw      date,
    atd_bt      char(1),
    atd_bt_dt   varchar2(25),
    atd_bt_ct   varchar2(10),
    atd_dp      char(1),
    atd_dp_dt   varchar2(25),
    atd_dp_ct   varchar2(10),
    spare1       varchar2(255),
    spare2       varchar2(255),
    spare3       varchar2(255),
    rgtr_id      varchar2(64),
    rgtr_dt      date,
    mdfr_id      varchar2(64),
    mdfr_dt      date
);

drop table tb_atd;

-- pk
alter table tb_atd
add constraint tb_atd_pk primary key(idx);

-- fk
-- �θ�Ű �� �������� �ʴ´ٴ� ���� �߻�
-- ORA-02291: ���Ἲ ��������(KUTSBANK.SYS_C008885)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�.
-- alter table tb_vac add constraint tb_atd_nm_fk foreign key (atd_nm) references tb_mbr(mbr_nm);
-- alter table tb_vac add constraint tb_atd_sn_fk foreign key (atd_sn) references tb_mbr(mbr_sn);

-- idx �� ����� ������
create sequence seq_atd_idx
start with 1
increment by 1;

create sequence seq_atd_sn
start with 300
increment by 1;

-- ������ �ʱ�ȭ��
drop sequence seq_atd_idx;
drop sequence seq_atd_sn;

-- ����� �ð��� ���� ��¥ ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy/MM/dd HH24:MI:SS';

-- ���� �׽�Ʈ�� ������ ���� (����� || CONCAT ���)
insert into tb_atd values
(seq_atd_idx.nextval, '������', '20220918'||seq_atd_sn.nextval, sysdate, sysdate, 'N', null, null, 'N', null, null, null, null, null, 'admin', sysdate, null, null);

insert into tb_atd values
(seq_atd_idx.nextval, '����', '20200418'||seq_atd_sn.nextval, sysdate, sysdate, 'Y', '2022/09/18~2022/10/21', '�뱸', 'N', null, null, null, null, null, 'admin', sysdate, null, null);

-- ���̺� Ȯ�� �� �ʱ�ȭ��
select * from tb_atd;
delete from tb_atd;

-- COMMIT �ʼ�
commit;

 -- tb_vac ����------------------------------------------------------------------------------------------------------------------------------
create table tb_vac (
    idx          number      not null,
    vac_nm       varchar2(50) not null,
    vac_sn       varchar2(20),
    vac_str      date,
    vac_end      date,
    vac_type     varchar2(10),
    vac_cnt      number,
    spare1       varchar2(255),
    spare2       varchar2(255),
    spare3       varchar2(255),
    spare4       varchar2(255),
    rgtr_id      varchar2(64),
    rgtr_dt      date,
    mdfr_id      varchar2(64),
    mdfr_dt      date
);

-- pk
alter table tb_vac
add constraint tb_vac_pk primary key(idx);

-- fk
-- �θ�Ű �� �������� �ʴ´ٴ� ���� �߻�
-- ORA-02291: ���Ἲ ��������(KUTSBANK.SYS_C008885)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�.
-- alter table tb_vac add constraint tb_vac_nm_fk foreign key (vac_nm) references tb_mbr(mbr_nm);
-- alter table tb_vac add constraint tb_vac_sn_fk foreign key (vac_sn) references tb_mbr(mbr_sn);


-- idx �� ����� ������
create sequence seq_vac_idx
start with 1
increment by 1;

create sequence seq_vac_sn
start with 300
increment by 1;

-- ������ �ʱ�ȭ��
drop sequence seq_vac_idx;
drop sequence seq_vac_sn;

-- ����� �ð��� ���� ��¥ ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy/MM/dd HH24:MI:SS';

-- ���� �׽�Ʈ�� ������ ���� (����� || CONCAT ���)
insert into tb_vac values
(seq_atd_idx.nextval, '������', '20220918'||seq_vac_sn.nextval, '20220920', '20220923', '����', 4, null, null, null, null, 'admin', sysdate, null, null);

insert into tb_vac values
(seq_atd_idx.nextval, '����', '20220223'||seq_vac_sn.nextval, null, null, null, null, null, null, null, null, 'admin', sysdate, null, null);

-- ���̺� Ȯ�� �� �ʱ�ȭ��
select * from tb_vac;
delete from tb_vac;

-- COMMIT �ʼ�
commit;