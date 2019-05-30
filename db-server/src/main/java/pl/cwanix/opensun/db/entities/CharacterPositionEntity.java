package pl.cwanix.opensun.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "character_position")
public class CharacterPositionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_character_position_generator")
	@SequenceGenerator(name = "seq_character_position_generator", sequenceName = "seq_character_position")
	private Long id;
	private int region;
	private int locationX;
	private int locationY;
	private int locationZ;
}