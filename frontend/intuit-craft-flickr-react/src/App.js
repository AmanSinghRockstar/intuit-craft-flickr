import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'reactstrap';
import './App.css';
import ImageGroup from './components/ImageGroup.js'

function App() {
  return (
    <div className="App">
      <Container>
        <ImageGroup/>
      </Container>
    </div>
  );
}

export default App;
