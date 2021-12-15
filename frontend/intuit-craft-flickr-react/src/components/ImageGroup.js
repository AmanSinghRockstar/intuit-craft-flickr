import { Component } from "react";
import {
    Row, Col, Card, Container,
    InputGroup,
    Input,
    Button,
} from 'reactstrap';

class ImageGroup extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentQuery: "",
            lastSearchedQuery: "",
            imageLinks: []
        };
        this.onClick = this.onClick.bind(this);
        this.handleQueryChange = this.handleQueryChange.bind(this);
    }

    componentDidMount() {
        document.title = 'Image Search';
    }

    handleQueryChange(e) {
        this.setState({
            currentQuery: e.target.value
        });
    }

    onClick(e) {
        let uri = 'http://localhost:8080/api/v1/image/search?query=' + this.state.currentQuery;

        if (this.state.currentQuery === "") {
            return
        }

        this.setState({
            imageLinks: []
        })

        fetch(uri, {
            method: 'GET'
        }).then(response => response.json())
        .then(responseData => {
            this.setState({
                imageLinks: responseData.imageUri,
                lastSearchedQuery: this.state.currentQuery
            })
        })
        .catch(() => {
            console.log("Failed to fetch image links");
        });
        this.setState({
            lastSearchedQuery: this.state.currentQuery
        })
    }

    render() {

        let list = this.state.imageLinks.map(imgLink => {
            return <img src={imgLink} height="250px"/>
        })
        return (
            <Container>
                <Row md="2">
                    <Col align="left"><h4>Images for {this.state.lastSearchedQuery}</h4></Col>
                    <Col sm="15">
                        <Card>
                            <InputGroup>
                                <Input value={this.state.currentQuery} onChange={this.handleQueryChange}/>
                                <Button onClick={this.onClick}>Search</Button>
                            </InputGroup>
                        </Card>
                    </Col>
                </Row>
                {list}
            </Container>
        )
    }
}

export default ImageGroup;