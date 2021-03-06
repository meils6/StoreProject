import React, { Component } from 'react';
import MenuItem from './MenuItem';
import 'whatwg-fetch';

const API_URL = 'http://localhost:8088';
const API_HEADERS = {
    'Content-Type':'application/json',
    'Authorization':'any-string-you-like' // The authorization is not needed for local server
};

class Navigator extends Component {
    constructor(props) {
        super(props);
        this.state = { categories: [] };
    }

    componentDidMount() {
        console.log('componentDidMount()');
        fetch(API_URL+'/category/findFirstLevel',{headers:API_HEADERS})
        .then((response) => response.json())
        .then((responseData) => {
            this.setState({categories:responseData});
        })
        .catch((error) => {
            console.log('Error fetching and parsing data',error);
        });
    }

    render() {
        var categoriesElements = this.state.categories.map((category,index) => {
                                    var c = 'color'+(index+2);
                                    return <MenuItem categoryId={category.id} class={c} caption={category.name} href="#" />
        });

        return (
            <ul className="megamenu skyblue">
                <li className="active grid">
                    <a className="color1" href="index.html">Home</a>
                </li>
                {categoriesElements}
            </ul>
        );
    }
}
export default Navigator;