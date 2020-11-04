import './App.css';
import React from "react";

const API = 'http://localhost:8081/weather/cities';

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            hits: [],
            hits2: {},
            details: [],
        };
        this.handleDropdownChange = this.handleDropdownChange.bind(this);
    }
    componentDidMount() {
        fetch(API)
            .then(response => response.json())
            .then(data => this.setState({ hits: data }));
    }

    handleDropdownChange(e) {
        const value = e.target.value;
        this.setState({ selectValue: e.target.value });
        fetch("http://localhost:8081/weather/city/" + value)
            .then(response => response.json())
            .then(data => this.setState({
              details: data.details
             }));
    }


    render()
    {
        const  hits = this.state.hits;
        const details = this.state.details;
        return (
            <div className="App">
                <header className="App-header">
                    <h1>Weather App</h1>

                <div>
                    
                    <div> Select City: 
                    <select onChange={this.handleDropdownChange}
                            defaultValue={{ label: "Select City", value: 0 }}>
                        {hits.map(item => (
                            <option
                                key={item.name}
                                value={item.id}
                            >
                                {item.name}
                            </option>
                        ))}
                    </select>
                    </div>
                    <ul>
                        {details.map(hit =>
                            <li><div>Date : {new Date(hit.date * 1000).toLocaleDateString("en-US")}</div>
                                <div>Min Temp: {hit.minTemp - 273} degree C</div>
                                <div>Max Temp: {hit.maxTemp- 273}  degree C</div>
                                <div>Description : {hit.description}</div>
                                <div>Type : {hit.type}</div>
                                <div>Suggestion : {(hit.type.includes('Rain') ? 'Carry Umbrella' : '')}</div>
                            </li>
                        )}
                    </ul>
                </div>
                <div>
                    <div>Selected value is : {this.state.selectValue}</div>
                </div>
                </header>
            </div>
        );
    }
}



export default App;
