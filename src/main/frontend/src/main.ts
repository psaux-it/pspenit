/// <reference types="svelte" />
import "svelte";
import App from './App.svelte';


const app = new App({
	target: document.body
});
// @ts-ignore
export default app;