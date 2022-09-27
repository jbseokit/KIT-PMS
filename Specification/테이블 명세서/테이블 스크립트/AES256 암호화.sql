-- DBMS_CRYPTO ���� �ο�
-- conn sys as sysdba;
-- grant execute on dbms_crypto to hr;

CREATE OR REPLACE PACKAGE HR.ENCRYPTION_AES
IS
    FUNCTION ENC_AES (INPUT_STRING IN VARCHAR2) RETURN VARCHAR2;
    FUNCTION DEC_AES (INPUT_STRING IN VARCHAR2) RETURN VARCHAR2;
END ENCRYPTION_AES;
/

CREATE OR REPLACE PACKAGE BODY HR.ENCRYPTION_AES
IS
    FUNCTION ENC_AES(INPUT_STRING IN VARCHAR2) RETURN VARCHAR2
    IS
        V_ORIGINAL_RAW RAW(130); -- ��ȣȭ�� ����Ÿ
        V_KEY_DATA_RAW RAW(64); -- Ű ��
        ENCRYTED_RAW RAW(320); -- ��ȣȭ�� ����Ÿ
        CONVERTED_STRING VARCHAR2(320); -- ����ȯ ����Ÿ
    BEGIN
        V_ORIGINAL_RAW:=UTL_I18N.STRING_TO_RAW(INPUT_STRING,'AL32UTF8'); -- VARCHAR2 -> RAWŸ������ ����(���������¾Ʒ���..)
        V_KEY_DATA_RAW:=UTL_I18N.STRING_TO_RAW('AKDKEKDKFKGKEKSD','AL32UTF8'); -- Ű �� RAWŸ������ ����.
        ENCRYTED_RAW:=DBMS_CRYPTO.ENCRYPT(SRC=>V_ORIGINAL_RAW,
                                                TYP=>DBMS_CRYPTO.ENCRYPT_AES128+
                                                DBMS_CRYPTO.CHAIN_CBC+
                                                DBMS_CRYPTO.PAD_PKCS5,
                                                KEY=>V_KEY_DATA_RAW);
        CONVERTED_STRING:=UTL_RAW.cast_to_varchar2(utl_encode.base64_encode(ENCRYTED_RAW));
        -- �߿�!!! rawŸ���� base64_encode()�� �̿��Ͽ� encoding�� varchar2Ÿ������ ��ȯ�ؾ��Ѵ�!! ������������
        -- ORA-06502: PL/SQL: numeric or value error: hex to raw conversion error �̷��� ������ �� �� �������̴�.
        RETURN CONVERTED_STRING;
    END ENC_AES;
    /******************************************************************************��ȣȭ��******************************************************************************/
    
    /******************************************************************************��ȣȭ******************************************************************************/
    FUNCTION DEC_AES(INPUT_STRING IN VARCHAR2) RETURN VARCHAR2
    IS  
        V_KEY_DATA_RAW RAW(64); -- Ű��
        DECRYPTED_RAW RAW(320); -- ��ȣȭ��
        CONVERTED_STRING VARCHAR2(320); -- ����ȯ����Ÿ
    BEGIN
        V_KEY_DATA_RAW:=UTL_I18N.STRING_TO_RAW('AKDKEKDKFKGKEKSD','AL32UTF8');
        DECRYPTED_RAW :=DBMS_CRYPTO.DECRYPT(SRC=>utl_encode.base64_decode(utl_raw.cast_to_raw(INPUT_STRING)),
        -- �߿�!!! varchar2Ÿ���� ����Ÿ�� rawŸ������ ��ȯ �� decoding�ؾ��Ѵ�!! ������������
        -- ORA-06502: PL/SQL: numeric or value error: hex to raw conversion error �̷��� ������ �� �� �������̴�.
                                                TYP=>DBMS_CRYPTO.ENCRYPT_AES128+
                                                DBMS_CRYPTO.CHAIN_CBC+
                                                DBMS_CRYPTO.PAD_PKCS5,
                                                KEY=>V_KEY_DATA_RAW);
        CONVERTED_STRING:=UTL_I18N.RAW_TO_CHAR(DECRYPTED_RAW,'AL32UTF8'); -- RAW -> CHARŸ������ ��ȯ�Ͽ� RETURN
        RETURN CONVERTED_STRING;
    END DEC_AES;
/******************************************************************************��ȣȭ��******************************************************************************/
END ENCRYPTION_AES;
/

SELECT ENCRYPTION_AES.ENC_AES('010-6678-2273') from tb_mbr;
select idx, mbr_nm, mbr_phone from tb_mbr;
select encryption_aes.dec_aes('abYaPXP0QBjqZ1cfJ7vVVQ==') from tb_mbr;

insert into tb_mbr (
    idx, mbr_sn, mbr_nm, mbr_enm,
    mbr_tel, mbr_phone, mbr_em,
    mbr_addr_bx, mbr_addr_post,
    mbr_dep_cd, mbr_hired_d,
    mbr_id, mbr_pw, mbr_cls_cd,
    rgtr_id, rgtr_dt) values 
    (seq_mbr_idx.nextval, '20200907'||seq_mbr_sn.nextval, '����ȯ', 'OhJongHwan',
    '7400', ENCRYPTION_AES.ENC_AES('010-6678-2273'), 'ojh22@naver.com', 
    '����Ư���� ���ʱ� ������27�� 29(���絿, �������?)', '137-890',
    'GENAFF', '2020/09/07', 
    'dhwhdghks', 'whdghks4268', 'GAAM01',
    'administrator', '2020/09/05'
    );
    
    select encryption_aes.dec_aes ( ENCRYPTION_AES.ENC_AES('010-6678-2273') ) from tb_mbr where idx=4;


