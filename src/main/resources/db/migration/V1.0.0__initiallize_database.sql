create table app_user(
    app_user_id bigserial primary key,
    username varchar(255) not null unique,
    email varchar(255) not null unique,
    password varchar(255) not null,
    active boolean not null,
    role varchar(50) not null
);

create table dungeon_master(
    dungeon_master_id bigserial primary key,
    description varchar(255),
    user_id bigint not null,
    constraint fk_user foreign key (user_id) references app_user (app_user_id)
);

create table campaign(
    campaign_id bigserial primary key,
    title varchar(255) not null,
    description varchar(255),
    is_visible boolean not null,
    is_private boolean not null,
    dungeon_master_id bigint not null,
    constraint fk_dungeon_master foreign key (dungeon_master_id) references dungeon_master (dungeon_master_id)
);

create table dnd_character(
    dnd_character_id bigserial primary key,
    name varchar(255) not null,
    description varchar(255),
    npc boolean not null,
    user_id bigint,
    campaign_id bigint not null,
    constraint fk_user foreign key (user_id) references app_user (app_user_id),
    constraint fk_campaign foreign key (campaign_id) references campaign (campaign_id)
);

create table session(
    session_id bigserial primary key,
    title varchar(255) not null,
    story varchar(255),
    date timestamp with time zone default CURRENT_TIMESTAMP not null,
    campaign_id bigint not null,
    constraint fk_campaign foreign key (campaign_id) references campaign (campaign_id)
);

create table entry(
    entry_id bigserial primary key,
    title varchar(255),
    dnd_character_id bigint,
    dungeon_master_id bigint,
    session_id bigint not null,
    constraint fk_dnd_character foreign key (dnd_character_id) references dnd_character (dnd_character_id),
    constraint fk_dnd_dungeon_master foreign key (dungeon_master_id) references dungeon_master (dungeon_master_id),
    constraint fk_session foreign key (session_id) references session (session_id)
);

create table action(
    action_id bigserial primary key,
    description varchar(255),
    entry_id bigint,
    constraint fk_entry foreign key (entry_id) references entry (entry_id)
);

create table note(
    note_id bigserial primary key,
    text varchar(255) not null,
    session_id bigint not null,
    dnd_character_id bigint,
    dungeon_master_id bigint,
    constraint fk_dnd_session foreign key (session_id) references session (session_id),
    constraint fk_dnd_character foreign key (dnd_character_id) references dnd_character (dnd_character_id),
    constraint fk_dungeon_master foreign key (dungeon_master_id) references dungeon_master (dungeon_master_id)
);