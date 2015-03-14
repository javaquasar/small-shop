package just4.fun.smallshop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zinchenko on 08.03.15.
 */
@Entity
@Table(name = "test_test")
@Indexed
@Analyzer(impl = org.apache.lucene.analysis.standard.StandardAnalyzer.class)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    @DocumentId
    private Long id;

    @Column(name = "name")
    @Field(store = Store.YES)
    private String name;

//    @OneToMany(mappedBy = "test")
//    @Field(index = Index.NO)
//    private List<SubTest> subTests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<SubTest> getSubTests() {
//        return subTests;
//    }

//    public void setSubTests(List<SubTest> subTests) {
//        this.subTests = subTests;
//    }
}
