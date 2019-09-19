-- 通话信息相关
truncate table sip_session_phone;
truncate table sip_session_phone_message;
truncate table sip_session_phone_message_warn;
truncate table sip_session_phone_message_label;

-- 热词及质检相关
truncate table sip_check_message_issue;
truncate table sip_check_message_record;
truncate table sip_hot_word_cycle;
truncate table sip_hot_word_result;
truncate table sip_hot_word_warn;

-- 登录日志
truncate table sip_seat_info_login;

-- 回听异常的日志记录
truncate table sip_log_read_error;

-- convert服务端删除DATAS音频数据，
-- redis - peter删除对应的待处理音频流数据
-- redis -sip 用户登录，座机号socket等信息删除

SELECT * from sip_seat_info_login
SELECT count(*) from sip_log_read_error

select * from sip_login_log