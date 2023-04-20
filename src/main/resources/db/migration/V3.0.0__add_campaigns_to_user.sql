create table campaign_app_user(
    users_app_user_id bigint,
    campaign_campaign_id bigint,
    constraint pk_campaign_app_user primary key (users_app_user_id, campaign_campaign_id),
    constraint fk_app_user foreign key (users_app_user_id) references app_user (app_user_id),
    constraint fk_campaign foreign key (campaign_campaign_id) references campaign (campaign_id)
);