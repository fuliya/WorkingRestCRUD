if there are multiple primary key in table we need to use composite key for spring data jpa
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Immutable
public class CompositeClass implements Serializable {
// add private variable for all the primary key

in the entity class you need to add below annotation
class level annotatio
@IdClass(CompositeClass.class)

and @Id for all the variable define in CompositeClass.
