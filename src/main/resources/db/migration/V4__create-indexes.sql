
CREATE UNIQUE INDEX unique_event_slug ON events(slug);

CREATE UNIQUE INDEX unique_attendee_event_and_email ON attendees(email, event_id);

CREATE UNIQUE INDEX unique_check_ins_attendee ON check_ins(attendee_id)


