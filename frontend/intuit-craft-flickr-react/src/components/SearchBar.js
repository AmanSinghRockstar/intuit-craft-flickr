import { Component } from "react";
import {
    InputGroup,
    Input,
    Button,
    Card
} from 'reactstrap';

class SearchBar extends Component {
    render() {
        return (
            <Card>
            <InputGroup>
                <Input />
                <Button>Search</Button>
            </InputGroup>
            </Card>
        )
    }
}

export default SearchBar;