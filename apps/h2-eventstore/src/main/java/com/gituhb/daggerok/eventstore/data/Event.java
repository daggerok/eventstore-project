package com.gituhb.daggerok.eventstore.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.OffsetTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@Setter(PROTECTED)
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Event implements Serializable {

  private static final long serialVersionUID = 6525808810958822538L;

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = AUTO)
  UUID id;

  @NonNull // lombok
  @Column(nullable = false)
  String message;

  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS Z")
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS Z", timezone = "UTC")
//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonDeserialize(using = OffsetTimeDeserializer.class)
  @JsonSerialize(using = ZonedDateTimeSerializer.class)
  ZonedDateTime createdAt;

  @LastModifiedDate
//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonDeserialize(using = OffsetTimeDeserializer.class)
  @JsonSerialize(using = OffsetDateTimeSerializer.class)
  ZonedDateTime lastModifiedAt;
}
